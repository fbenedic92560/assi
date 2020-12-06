package obl;

import labeling.SecurityLevel;
import securesystem.SecureSystem;

/**
 *
 * @author martellocauda
 */
public class OBL {
    private static final String OPTION_HELP = String.join(
            ""
            , "\nUsage:\n\n"
            , "1) java OBL -i <instruction list file>\n"
            , "     <instruction list> instruction to execute and print state of subjects and objects\n"
            , "2) java OBL -m <message file> <sequence file>\n"
            , "     <message file> message to send throught covert channel\n"
            , "     <sequence file> sequence of subject's execution to send the message\n"
            , "3) java -h\n"
            , "     print this help\n\n"
    );
    private enum Option { INSTRUCTIONLIST, COVERTCHANNEL };
    
    private static String instructionListFileName;
    private static String messageFileName;
    private static String sequenceFileName;
    
    private static Option optionToProcess;
    
    private static SecureSystem secureSystem;
    
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {        
        processParameters(args);
        
        loadDefaultSubjectsAndObjects();
        
        switch (optionToProcess) {
            case INSTRUCTIONLIST:
                processInstructionList();
                break;
            case COVERTCHANNEL:
        }
        
        System.exit(0);
    }
    
    private static void processInstructionList() {
        secureSystem.readFile(instructionListFileName);
    }
    
    private static void processCovertChannel() {
        //
    }
    
    private static void loadDefaultSubjectsAndObjects() {
        secureSystem = new SecureSystem();
        
        secureSystem.createObject("lobj", SecurityLevel.LOW);
        secureSystem.createObject("mobj", SecurityLevel.MEDIUM);
        secureSystem.createObject("hobj", SecurityLevel.HIGH);
        
        secureSystem.createSubject("lyle", SecurityLevel.LOW);
        secureSystem.createSubject("moe", SecurityLevel.MEDIUM);
        secureSystem.createSubject("hal", SecurityLevel.HIGH);
    }
    
    private static void processParameters(String[] args) {
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
