import sys
input = sys.stdin.readline

# 전위순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)

def preorder(cur):
  # 루 -> 왼 -> 오
  # 종료 코드
  # 루트 방문
  print(chr(cur+ord('A')), end ='')
  if tree[cur][0] == -19 and tree[cur][1] == -19:
    return
  #왼쪽 노드 방문
  if tree[cur][0] != -19:
    preorder(tree[cur][0])
  # 오른쪽 노드 방문 
  if tree[cur][1] != -19:
    preorder(tree[cur][1])
def inorder(cur):
  # 왼 -> 루 -> 오
  # 왼쪽값 출력 and 왼쪽 노드 방문
  if tree[cur][0] != -19:
    inorder(tree[cur][0])
  # 루트노드 출력
  print(chr(cur+ord('A')), end ='')

  # 오른쪽 노드 방문
  if tree[cur][1] != -19:
    inorder(tree[cur][1])
  
def postorder(cur):
  #왼 -> 오 -> 루
  if tree[cur][0] != -19:
    postorder(tree[cur][0])

  # 오른쪽 노드 방문
  if tree[cur][1] != -19:
    postorder(tree[cur][1])

  # 루트노드 출력
  print(chr(cur+ord('A')), end ='')


N = int(input())
tree = [[-19,-19] for _ in range(26)]
for _ in range(N):
  root, l, r = input().split()
  tree[ord(root)-ord('A')] = [ord(l)-ord('A'), ord(r)-ord('A')]

preorder(0)
print()
inorder(0)
print()
postorder(0)