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
        if(skill.length()==1) answer=skill_trees.length; //1���ڸ� ������ ��;;
        else {
	        for(int i=0;i<skill_trees.length;i++) {
	        	int flag=0;
	        	tmp_idx=skill_trees[i].indexOf(skill.charAt(0));
	        	if(tmp_idx==-1) flag=1;  	
	        	for(int j=1;j<skill.length();j++) {
	        		idx=skill_trees[i].indexOf(skill.charAt(j));
	        		if(idx==-1) flag=1;//���� ��, ��� �� �������
	        		else if(tmp_idx<idx && flag!=1){ //���� ��
	        			flag=2;
	        		}
	        		else { //���� ��
	        			flag=0;break;
	        		}
	        		tmp_idx=idx;
	        	}
	        	if(flag!=0) answer++; //�۾Ƽ� ���� ��찡 �ƴ϶�� answer++����
	        }
       
        }
        return answer;
    }

}
