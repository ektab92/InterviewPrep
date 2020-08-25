package com.practice.ds.amazon.linkedList;

public class DetectCycleRemoveCycle {
    //ptr1 to save the point at which fast_ptr and slow_ptr meet
    ListNode ptr1=null;

    private boolean detectCycle(ListNode head)
    {
        ListNode fast_ptr=head;
        ListNode slow_ptr=head;
        while(fast_ptr!=null && fast_ptr.next != null )
        {
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
            if(slow_ptr == fast_ptr)
            {
                ptr1=slow_ptr;
                return true;
            }
        }
        return false;
    }
    private int findLengthOfCycle()
    {
        ListNode ptr2 = ptr1.next;
        int len =1;
        while(ptr1 != ptr2)
        {
            ptr2= ptr2.next;
            len++;
        }
        return len;
    }
    private void removeCycle(ListNode head,int k)
    {
        ListNode ptr1 = head;
        while(k>0)
        {
            ptr1=ptr1.next;
            k--;
        }
        ListNode ptr2 = head;
        while(ptr1!= ptr2)
        {
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        ptr2 = ptr1.next;
        while(ptr2.next != ptr1)
        {
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }
    private void driver(ListNode head)
    {
        if(head == null) return;
        if(detectCycle(head))
        {
            int k=findLengthOfCycle();
            System.out.println("length "+k);
            removeCycle(head,k);
        }

    }
    public static void main(String[] args) {
        DetectCycleRemoveCycle cycleDetection = new DetectCycleRemoveCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next.next;
        cycleDetection.driver(head);
        while(head!=null)
        {
            System.out.println(head.data+" -> ");
            head=head.next;

        }
    }
}
