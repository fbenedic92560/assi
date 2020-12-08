package obl;

import entitysubject.EntitySubject;
import java.io.FileWriter;
import labeling.SecurityLevel;
import securesystem.SecureSystem;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author martellocauda
 */
public class OBL {

    private static final String OPTION_HELP = String.join(
            "",
            "\nUsage:\n\n",
            "1) java OBL -i <instruction list file>\n",
            "     <instruction list> instruction to execute and print state of subjects and objects\n",
            "2) java OBL -m <message file> <sequence file>\n",
            "     <message file> message to send throught covert channel\n",
            "     <sequence file> sequence of subject's execution to send the message\n",
            "3) java -h\n",
            "     print this help\n\n"
    );

    private enum Option {
        INSTRUCTIONLIST, COVERTCHANNEL, NONE
    };

    private static String instructionListFileName;
    private static String messageFileName;
    private static String sequenceFileName;
    private static String outputFileName;

    private static Option optionToProcess = Option.NONE;

    private static SecureSystem secureSystem;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println();
        processParameters(args);

        loadDefaultSubjectsAndObjects();

        switch (optionToProcess) {
            case INSTRUCTIONLIST:
                processInstructionList();
                break;
            case COVERTCHANNEL:
                processCovertChannel();
                break;
            case NONE:
                System.exit(0);
                break;
        }

        System.exit(0);
    }

    private static void processInstructionList() {
        secureSystem.readFile(instructionListFileName);
    }

    private static void processCovertChannel() {
        secureSystem.covertChannel(messageFileName, sequenceFileName, outputFileName);
    }

    private static void loadDefaultSubjectsAndObjects() {
        secureSystem = new SecureSystem();

        secureSystem.createObject("lobj", new EntitySubject("lyle", SecurityLevel.LOW));
        secureSystem.createObject("mobj", new EntitySubject("moe", SecurityLevel.MEDIUM));
        secureSystem.createObject("hobj", new EntitySubject("hal", SecurityLevel.HIGH));

        secureSystem.createSubject("lyle", SecurityLevel.LOW);
        secureSystem.createSubject("moe", SecurityLevel.MEDIUM);
        secureSystem.createSubject("hal", SecurityLevel.HIGH);
    }

    private static void processParameters(String[] args) {
        if (args.length == 0) {
            printHelp();
            System.exit(0);
        }
        switch (args[0]) {
            case "-i":
                processParametersInstructionList(args);
                break;
            case "-m":
                processParametersCovertChannel(args);
                break;
            case "-h":
                printHelp();
                break;
            default:
                printHelp();
        }
    }

    private static void processParametersCovertChannel(String[] args) {
        if (args.length != 3) {
            printHelp();
            System.exit(1);
        }
        messageFileName = args[1];
        sequenceFileName = args[2];
        String[] splittedSecuenceFileName = sequenceFileName.split("\\\\", 0);
        String[] onlyPathSequenceFileName = Arrays.copyOf(splittedSecuenceFileName, splittedSecuenceFileName.length - 1);
        String onlyPathSequenceFileNameInString = "";
        for (int i = 1; i < onlyPathSequenceFileName.length; i += 2) {
            onlyPathSequenceFileName[i] = "\\\\";
        }
        for (int i = 0; i < onlyPathSequenceFileName.length; i++) {
            onlyPathSequenceFileNameInString += onlyPathSequenceFileName[i];
        }
        outputFileName = onlyPathSequenceFileNameInString + "salida.txt";
        optionToProcess = Option.COVERTCHANNEL;
    }

    private static void processParametersInstructionList(String[] args) {
        if (args.length != 2) {
            printHelp();
            System.exit(1);
        }
        instructionListFileName = args[1];
        optionToProcess = Option.INSTRUCTIONLIST;
    }

    private static void printHelp() {
        System.out.print(OPTION_HELP);
    }
}
