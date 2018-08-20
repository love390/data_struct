package com.cgg.struct.tree;

import com.cgg.SectionTools;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-20 13:07:04
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 * 二分搜索树
 */
public class BStree {
    class BStreeEle {
        private BStreeEle leBtree;
        private BStreeEle riBtree;

        private Integer data;


        public void copyTo(BStreeEle target) {
            target.setRiBtree(this.getRiBtree());
            target.setLeBtree(this.getLeBtree());
            target.setData(this.getData());
        }

        public BStreeEle getLeBtree() {
            return leBtree;
        }

        public void setLeBtree(BStreeEle leBtree) {
            this.leBtree = leBtree;
        }

        public BStreeEle getRiBtree() {
            return riBtree;
        }

        public void setRiBtree(BStreeEle riBtree) {
            this.riBtree = riBtree;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }
    }

    private BStreeEle root;

    public BStree() {
    }

    public void inert(Integer data) {
        this.root = this.insert(this.root, data);
    }

    private BStreeEle insert(BStreeEle btreeEle, Integer data) {
        if (btreeEle == null) {
            btreeEle = new BStreeEle();
            btreeEle.setData(data);
            return btreeEle;
        }
        if (btreeEle.getData() > data) {
            btreeEle.setLeBtree(insert(btreeEle.getLeBtree(), data));
        } else if (btreeEle.getData() < data) {
            btreeEle.setRiBtree(insert(btreeEle.getRiBtree(), data));
        }
        return btreeEle;
    }

    public boolean contain(Integer data) {
        return this.search(this.root, data) != null;
    }
//
//    /**
//     * 还是c,c++的指针操作方便，java没法直接改引用
//     * @param btreeEle
//     * @param data
//     * @return
//     */
//    public void delete(Integer data) {
//        BStreeEle btreeEleParent = this.searchParent(this.root, data);
//        if (btreeEleParent == null) return;//无匹配结果，直接返回
//        BStreeEle btreeEle = null;
//        if (btreeEleParent.getLeBtree() != null && btreeEleParent.getLeBtree().data == data)
//            btreeEle = btreeEleParent.getLeBtree();
//        else btreeEle = btreeEleParent.getRiBtree();
//
//
//        if (btreeEle.getRiBtree() != null && btreeEle.getLeBtree() != null) {//左右子树都不为空
//            BStreeEle btreeLe = btreeEle.getLeBtree();//保存待删除节点左子树最大节点
//            BStreeEle btreeEleRoot = btreeLe;//获取待删除节点左子树最大节点的父节点，用于后期删除
//
//            while (btreeLe != null && btreeLe.getRiBtree() != null) {//获取待删除节点左子树最大节点
//                btreeEleRoot = btreeLe;
//                btreeLe = btreeLe.getRiBtree();
//            }
//
//            if (btreeLe == btreeEleRoot) {//左子树最大节点恰好为删除节点左子节点
//                btreeLe.copyTo(btreeEle);
//                btreeLe = null;
//            } else {//左子树最大节点在左子树有孩子上
//                btreeEleRoot.riBtree = null;
//                btreeEle.data = btreeLe.data;//将当前需删除节点的内容改为左子树最大节点内容
//            }
//        } else if (btreeEle.getRiBtree() == null && btreeEle.getLeBtree() != null) {//右子树为空
//            btreeEle.getLeBtree().copyTo(btreeEle);
//            btreeEle.setLeBtree(null);
//        } else if (btreeEle.getRiBtree() != null && btreeEle.getLeBtree() == null) {//左子树为空
//            btreeEle.getRiBtree().copyTo(btreeEle);
//            btreeEle.setRiBtree(null);
//        } else if (btreeEle.getRiBtree() == null && btreeEle.getLeBtree() == null) {
//            btreeEle = null;
//        }
//    }

    private BStreeEle search(BStreeEle btreeEle, Integer data) {
        if (btreeEle == null) return null;
        else {
            if (btreeEle.data == data) return btreeEle;
            if (btreeEle.data > data) return search(btreeEle.leBtree, data);
            else return search(btreeEle.riBtree, data);
        }
    }


    private BStreeEle searchParent(BStreeEle btreeEle, Integer data) {
        if (btreeEle == null) return null;
        else {
            if (btreeEle.data > data) {
                if (btreeEle.getLeBtree() != null && btreeEle.getLeBtree().data == data) return btreeEle;
                else return search(btreeEle.leBtree, data);
            } else {
                if (btreeEle.getRiBtree() != null && btreeEle.getRiBtree().data == data) return btreeEle;
                else return search(btreeEle.riBtree, data);
            }
        }
    }

    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();
        preOrder(this.root, list);
        return list;
    }

    public List<Integer> midOrder() {
        List<Integer> list = new ArrayList<>();
        midOrder(this.root, list);
        return list;
    }

    public List<Integer> afOrder() {
        List<Integer> list = new ArrayList<>();
        afOrder(this.root, list);
        return list;
    }

    private void preOrder(BStreeEle btreeEle, List list) {
        if (btreeEle != null) {
            list.add(btreeEle.getData());
            preOrder(btreeEle.getLeBtree(), list);
            preOrder(btreeEle.getRiBtree(), list);
        }
    }

    private void midOrder(BStreeEle btreeEle, List list) {
        if (btreeEle != null) {
            midOrder(btreeEle.getLeBtree(), list);
            list.add(btreeEle.getData());
            midOrder(btreeEle.getRiBtree(), list);
        }
    }

    private void afOrder(BStreeEle btreeEle, List list) {
        if (btreeEle != null) {
            afOrder(btreeEle.getLeBtree(), list);
            afOrder(btreeEle.getRiBtree(), list);
            list.add(btreeEle.getData());
        }
    }

    public Integer min() {
        BStreeEle btreeEle = this.root;
        while (btreeEle != null && btreeEle.getLeBtree() != null) {
            btreeEle = btreeEle.getLeBtree();
        }
        return btreeEle == null ? -1 : btreeEle.getData();
    }

    public Integer max() {
        BStreeEle btreeEle = this.root;
        while (btreeEle != null && btreeEle.getRiBtree() != null) {
            btreeEle = btreeEle.getRiBtree();
        }
        return btreeEle == null ? -1 : btreeEle.getData();
    }

    public static void main(String[] args) throws Exception {
        List list = SectionTools.getRandomData(10, 30, 20);
        BStree BStree = new BStree();
        for (Object obj : list) {
            BStree.inert((Integer) obj);
        }

        System.out.println("前序遍历");
        SectionTools.print(BStree.preOrder());

        System.out.println("中序遍历");
        SectionTools.print(BStree.midOrder());

        System.out.println("后序遍历");
        SectionTools.print(BStree.afOrder());

        System.out.println("最小值：" + BStree.min());

        System.out.println("最大值：" + BStree.max());

        System.out.println("是否包含20：" + BStree.contain(20));
//
//        System.out.println("删除20节点");
//        BStree.delete(20);
//
//        System.out.println("中序遍历");
//        SectionTools.print(BStree.midOrder());
//
//        System.out.println("是否包含20：" + BStree.contain(20));
    }
}
