
class Solution:
    def sortList(self, head):
        if not head or not head.next:
            return head  

        def split(head, k):
            """Splits the list into two parts: first `k` nodes and the rest."""
            prev = None
            while k > 0 and head:
                prev = head
                head = head.next
                k -= 1
            if prev:
                prev.next = None  
            return head

        def merge(l1, l2):
            dummy = tail = ListNode(0)

            while l1 and l2:
                if l1.val <= l2.val:
                    tail.next, l1 = l1, l1.next
                else:
                    tail.next, l2 = l2, l2.next
                tail = tail.next

            tail.next = l1 if l1 else l2  
            while tail.next: 
                tail = tail.next

            return dummy.next, tail

        length = 0
        curr = head
        while curr:
            length += 1
            curr = curr.next

        dummy = ListNode(0)
        dummy.next = head
        k = 1

        while k < length:
            curr, tail = dummy.next, dummy
            while curr:
                l = curr
                r = split(l, k)
                curr = split(r, k)
                mergedHead, mergedTail = merge(l, r)
                tail.next = mergedHead
                tail = mergedTail 
            k *= 2 

        return dummy.next