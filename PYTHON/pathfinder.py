class Node(object):
def __init__(self, index, neighbors):
self.index = index
# A set of indices (integers, not Nodes)
self.neighbors = set(neighbors)
def add_neighbor(self, neighbor):
self.neighbors.add(neighbor)
class Component(object):
def __init__(self, nodes):
self.nodes = nodes
self.adjacent_nodes = set()
for node in nodes:
self.adjacent_nodes.add(node.index)
self.adjacent_nodes.update(node.neighbors)
def size(self):
return len(self.nodes)
def node_indices(self):
return set(node.index for node in self.nodes)
def is_saturated(self):
return self.node_indices == self.adjacent_nodes
def add_node(self, node):
self.nodes.append(node)
self.adjacent_nodes.update(node.neighbors)
adj_matrix = [[0, 0, 0, 0, 0, 0, 0, 1, 1, 0],
[0, 0, 0, 1, 1, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
[0, 1, 0, 0, 0, 0, 0, 0, 1, 0],
[0, 1, 0, 0, 0, 0, 0, 1, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
[1, 0, 0, 0, 1, 1, 0, 0, 0, 0],
[1, 0, 0, 1, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]
matrix_size = len(adj_matrix)
nodes = {}
for index in range(matrix_size):
neighbors = [neighbor for neighbor, value in enumerate(adj_matrix[index])
if value == 1]
nodes[index] = Node(index, neighbors)
components = []
index, node = nodes.popitem()
component = Component([node])
while nodes:
if not component.is_saturated:
missing_node_index = component.adjacent_nodes.difference(component.node_indices).pop()
missing_node = nodes.pop(missing_node_index)
component.add_node(missing_node)
else:
components.append(component)
index, node = nodes.popitem()
component = Component([node])
components.append(component)
print max([component.size for component in components])