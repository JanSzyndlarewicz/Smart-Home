package Subject;

import java.util.ArrayList;

public class SubjectExtendedList{
    protected ArrayList<SubjectExtended> subjectExtendedList = new ArrayList<>(); //list of "subjects"


    public void addSubjectExtended(Subject subject ,String alias){
        subjectExtendedList.add(new SubjectExtended(subject, alias));
    }

    public void removeSubjectExtended(SubjectExtended subjectExtended){
        subjectExtendedList.remove(subjectExtended);
    }

    public void removeSubjectExtended(int n){
        subjectExtendedList.remove(n);
    }

    public ArrayList<SubjectExtended> getSubjectExtendedList() {
        return subjectExtendedList;
    }

    public void setSubjectExtendedList(ArrayList<SubjectExtended> subjectExtendedList) {
        this.subjectExtendedList = subjectExtendedList;
    }


    @Override
    public String toString() {
        return "SubjectExtendedList{" +
                "subjectExtendedList=" + subjectExtendedList.toString() +
                '}';
    }
}
