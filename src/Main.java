import java.io.*;
import java.util.*;

public class Main {
    public static AssemblyProgram assemblyProgram = new AssemblyProgram();
    public static void main(String[] args) throws IllegalStateException, IOException {
        Scanner scn = new Scanner(System.in);
        System.out.println("SELECT ONE OF THE FOLLOWING COMMANDS:");
        System.out.println("'MV' to make a new variable");
        System.out.println("'ADD' to add the values of register");
        System.out.println("'SHOW' to see the result of a register");
        System.out.println("'EXIT' or 'QUIT' to terminate the program");
        boolean flag = true;
        assemblyProgram.registers = readFromFile();
        while(flag){
            String input = scn.nextLine();
            String[] word = input.split("[\\s,]+");
            switch (word[0].toUpperCase()) {
                case "MV" -> {
                    assemblyProgram.executeProgram(new Instruction(Operation.MV, new String[]{word[1], word[2]}));
                    storeRegisterValues(assemblyProgram.registers);
                }
                case "ADD" -> {
                    assemblyProgram.executeProgram(new Instruction(Operation.ADD, new String[]{word[1], word[2]}));
                    storeRegisterValues(assemblyProgram.registers);
                }
                case "SHOW" -> {
                    assemblyProgram.executeProgram(new Instruction(Operation.SHOW, new String[]{word[1]}));
                    storeRegisterValues(assemblyProgram.registers);
                }
                case "EXIT","QUIT","-1" -> {
                    flag = false;
                    System.out.println("This program has been terminated");
                }
                default ->
                        throw new IllegalStateException("Unexpected value: " + word[0]);
            }
        }
    }

    private static void storeRegisterValues(Map<String,Integer> registers) {
        try {
            FileWriter writer = new FileWriter("register_values.txt");
            for (Map.Entry<String, Integer> entry : registers.entrySet()){
               writer.append(entry.getKey() + " " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static HashMap readFromFile() throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("register_values.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                int value = Integer.parseInt(parts[1]);
                if(!map.containsKey(key))
                    map.put(key, value);
            }
        }
        return map;
    }

}







