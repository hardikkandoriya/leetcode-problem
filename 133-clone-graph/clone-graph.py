class Solution:
    def cloneGraph(self, node):
        if not node:
            return None
        cloned_nodes = {}
        def dfs(original):
            if original in cloned_nodes:
                return cloned_nodes[original]

            clone = Node(original.val)
            cloned_nodes[original] = clone

            for neighbor in original.neighbors:
                clone.neighbors.append(dfs(neighbor))
            return clone
        return dfs(node)