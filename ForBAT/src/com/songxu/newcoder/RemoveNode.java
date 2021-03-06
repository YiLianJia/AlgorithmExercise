package com.songxu.newcoder;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。 
 * 给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 * 
 * @author songxu
 *
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class RemoveNode {

	public boolean removeNode(ListNode pNode) {
		
		if(pNode==null||pNode.next==null)
		{
			return false;
		}
		/**
		 * 让当前节点称为当前节点的下一个节点
		 */
		pNode.val=pNode.next.val;
		pNode.next=pNode.next.next;
		
		return true;
	}
}
