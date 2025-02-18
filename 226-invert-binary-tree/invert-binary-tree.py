class Solution:
  def invertTree(self, root):
    if not root:
      return None

    left = root.left  
    right = root.right
    root.left = self.invertTree(right)  #assign tree's actual right node as left node .
    root.right = self.invertTree(left) #assign trees actual left node as right node .
    return root

