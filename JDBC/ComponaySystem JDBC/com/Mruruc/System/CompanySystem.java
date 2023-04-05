package com.Mruruc.System;

public class CompanySystem  implements Company{
    private Node head;
    private int counter;

    public CompanySystem() {
    }

    @Override
    public void add(Employee employee) {
       Node node =new Node(employee.getId(), employee.getfName(), employee.getlName(), employee.getEmail());
       node.next=head;
       head=node;
       counter++;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void read() {
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.getId() +" "+temp.getfName() +" "+temp.getlName()+" "+temp.getEmail());
            temp=temp.next;
        }

    }

    @Override
    public void readById(int id) {

    }


        @Override
        public void delete(int id) {

        }

}
