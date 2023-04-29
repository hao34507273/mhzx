/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynBagAddItem
/*    */   extends __SSynBagAddItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584733;
/*    */   public ArrayList<Integer> grids;
/*    */   public int itemid;
/*    */   public int count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584733;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynBagAddItem()
/*    */   {
/* 35 */     this.grids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynBagAddItem(ArrayList<Integer> _grids_, int _itemid_, int _count_) {
/* 39 */     this.grids = _grids_;
/* 40 */     this.itemid = _itemid_;
/* 41 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.grids.size());
/* 50 */     for (Integer _v_ : this.grids) {
/* 51 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 53 */     _os_.marshal(this.itemid);
/* 54 */     _os_.marshal(this.count);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 61 */       int _v_ = _os_.unmarshal_int();
/* 62 */       this.grids.add(Integer.valueOf(_v_));
/*    */     }
/* 64 */     this.itemid = _os_.unmarshal_int();
/* 65 */     this.count = _os_.unmarshal_int();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SSynBagAddItem)) {
/* 75 */       SSynBagAddItem _o_ = (SSynBagAddItem)_o1_;
/* 76 */       if (!this.grids.equals(_o_.grids)) return false;
/* 77 */       if (this.itemid != _o_.itemid) return false;
/* 78 */       if (this.count != _o_.count) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.grids.hashCode();
/* 87 */     _h_ += this.itemid;
/* 88 */     _h_ += this.count;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.grids).append(",");
/* 96 */     _sb_.append(this.itemid).append(",");
/* 97 */     _sb_.append(this.count).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SSynBagAddItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */