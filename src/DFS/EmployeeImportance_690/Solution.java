package DFS.EmployeeImportance_690;

import java.util.List;

class Solution {
    Employee[] empList = new Employee[2001];
    public int getImportance(List<Employee> employees, int id) {
        for (Employee e: employees)
            empList[e.id] = e;
        return importance(id);
    }

    private int importance(int id){
        Employee e = empList[id];
        int weight = e.importance;
        for (int subId: e.subordinates)
            weight += importance(subId);
        return weight;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
