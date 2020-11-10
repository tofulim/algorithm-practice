package prc1.programmers_kit;

public class prog_swc_skilltree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill="D";
		String[] skill_trees= {"BACDE", "CBADF", "AECB", "BDA","K"};
		solution(skill,skill_trees);
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int idx=0;
        int tmp_idx=0;
        if(skill.length()==1) answer=skill_trees.length; //1글자면 무조건 됨;;
        else {
	        for(int i=0;i<skill_trees.length;i++) {
	        	int flag=0;
	        	tmp_idx=skill_trees[i].indexOf(skill.charAt(0));
	        	if(tmp_idx==-1) flag=1;  	
	        	for(int j=1;j<skill.length();j++) {
	        		idx=skill_trees[i].indexOf(skill.charAt(j));
	        		if(idx==-1) flag=1;//없을 때, 계속 쭉 없어야함
	        		else if(tmp_idx<idx && flag!=1){ //있을 때
	        			flag=2;
	        		}
	        		else { //작을 때
	        			flag=0;break;
	        		}
	        		tmp_idx=idx;
	        	}
	        	if(flag!=0) answer++; //작아서 나온 경우가 아니라면 answer++해줌
	        }
       
        }
        return answer;
    }

}
