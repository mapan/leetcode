void PreOrderPrint(NODE* pRoot)
{
    assert(pRoot);
 
    NODE* pCur = pRoot;
    while (pCur != NULL)
    {
        cout<<pCur->nVal<<endl;
 
        if (pCur->pLft != NULL)
            pCur = pCur->pLft;
        else if (pCur->pRgt != NULL)
            pCur = pCur->pRgt;
        else
        {
            while (pCur->pParent != NULL && pCur != pCur->pParent->pLft)
                pCur = pCur->pParent;
 
            if (pCur->pParent == NULL) 
                break;
            else pCur = pCur->pParent->pRgt;
        }
    }
}

void InOrderPrint(NODE* pRoot)
{
    NODE* pCur = pRoot;
    while (pCur != NULL)
    {
        while (pCur->pLft != NULL)
            pCur = pCur->pLft;
        print(pCur);
        if (pCur->pRgt != NULL)
            pCur = pCur->pRgt;
        else
        {
            while (pCur->pParent != NULL && pCur != pCur->pParent->pLft)
                pCur = pCur->pParent;
 
            if (pCur->pParent == NULL) 
                break;
            print(pCur->parent);
            pCur = pCur->pParent->pRgt;
        }
    }
}
