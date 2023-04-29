/*    */ package mzm.gsp.market;
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
/*    */ public class SQueryItemPricRes
/*    */   extends __SQueryItemPricRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601404;
/*    */   public int itemid;
/*    */   public ArrayList<Integer> prices;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601404;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SQueryItemPricRes()
/*    */   {
/* 32 */     this.prices = new ArrayList();
/*    */   }
/*    */   
/*    */   public SQueryItemPricRes(int _itemid_, ArrayList<Integer> _prices_) {
/* 36 */     this.itemid = _itemid_;
/* 37 */     this.prices = _prices_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.itemid);
/* 46 */     _os_.compact_uint32(this.prices.size());
/* 47 */     for (Integer _v_ : this.prices) {
/* 48 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.itemid = _os_.unmarshal_int();
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 57 */       int _v_ = _os_.unmarshal_int();
/* 58 */       this.prices.add(Integer.valueOf(_v_));
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SQueryItemPricRes)) {
/* 69 */       SQueryItemPricRes _o_ = (SQueryItemPricRes)_o1_;
/* 70 */       if (this.itemid != _o_.itemid) return false;
/* 71 */       if (!this.prices.equals(_o_.prices)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.itemid;
/* 80 */     _h_ += this.prices.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.itemid).append(",");
/* 88 */     _sb_.append(this.prices).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SQueryItemPricRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */