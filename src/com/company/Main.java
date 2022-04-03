package com.company;

public class Main {

    public static void main(String[] args) {
        // a few examples
        int p = ProblemSolution.minimumChanges("H123sd67340aaakkkcccccs"); // 4 changes
        int p1 = ProblemSolution.minimumChanges("H123sd67340aaakkkccccc"); // 3 changes
        int p2 = ProblemSolution.minimumChanges("bbtttttttttttttttmmmmmmmmmmmmm"); // 15 changes
        int p3 = ProblemSolution.minimumChanges(""); // 6 changes
        int p4 = ProblemSolution.minimumChanges("123"); // 3 changes
        int p5 = ProblemSolution.minimumChanges("abcdefghijklmnopqrstuvwxyz"); // 8 changes
        int p6 = ProblemSolution.minimumChanges("123456789"); //2 changes
        int p7 = ProblemSolution.minimumChanges("123456789LLLLLLLLLLLLLLLLLLLLLLLLL"); // 17 changes
        int p8 = ProblemSolution.minimumChanges("111AB33333asssvvvkkkllllllaaaannnnzzz"); // 17 changes
        int p9 = ProblemSolution.minimumChanges(""); // 6 changes
        int p10 = ProblemSolution.minimumChanges("1Abcdefgt"); // 0 changes
        System.out.println(p + " " +p1 + " " + p2 +" " + p3 + " " + p4 + " " + p5 + " " + p6 + " " + p7 + " " + p8 + " " + p9 + " " + p10);
    }
}
