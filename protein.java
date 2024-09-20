import java.util.List;
import java.util.ArrayList;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> ans=new ArrayList<>();
        String s="";
        for(int i=0;i<rnaSequence.length();i++){
            if((i+1)%3==0){
                s+=rnaSequence.charAt(i);
                if(s.equals("AUG"))
                    ans.add("Methionine");
                else if(s.equals("UUU")||s.equals("UUC"))
                    ans.add("Phenylalanine");
                else if(s.equals("UUA")||s.equals("UUG"))
                    ans.add("Leucine");
                else if(s.equals("UCU")||s.equals("UCC")||s.equals("UCA")||s.equals("UCG"))
                    ans.add("Serine");
                else if(s.equals("UAU")||s.equals("UAC"))
                    ans.add("Tyrosine");
                else if(s.equals("UGU")||s.equals("UGC"))
                    ans.add("Cysteine");
                else if(s.equals("UGG"))
                    ans.add("Tryptophan");
                else if(s.equals("UAA")||s.equals("UAG")||s.equals("UGA"))
                    return ans;
                else
                    throw new IllegalArgumentException("Invalid codon");
                s="";
            }
            else
            s+=rnaSequence.charAt(i);
        }
        if(s!="")
            throw new IllegalArgumentException("Invalid codon");
        return ans;
    }
}
