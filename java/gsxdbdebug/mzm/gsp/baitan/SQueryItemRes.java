/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SQueryItemRes
/*    */   extends __SQueryItemRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584985;
/*    */   public int index;
/*    */   public int itemid;
/*    */   public int price;
/*    */   public ItemInfo iteminfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584985;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SQueryItemRes()
/*    */   {
/* 34 */     this.iteminfo = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SQueryItemRes(int _index_, int _itemid_, int _price_, ItemInfo _iteminfo_) {
/* 38 */     this.index = _index_;
/* 39 */     this.itemid = _itemid_;
/* 40 */     this.price = _price_;
/* 41 */     this.iteminfo = _iteminfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.iteminfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.index);
/* 51 */     _os_.marshal(this.itemid);
/* 52 */     _os_.marshal(this.price);
/* 53 */     _os_.marshal(this.iteminfo);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.index = _os_.unmarshal_int();
/* 59 */     this.itemid = _os_.unmarshal_int();
/* 60 */     this.price = _os_.unmarshal_int();
/* 61 */     this.iteminfo.unmarshal(_os_);
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SQueryItemRes)) {
/* 71 */       SQueryItemRes _o_ = (SQueryItemRes)_o1_;
/* 72 */       if (this.index != _o_.index) return false;
/* 73 */       if (this.itemid != _o_.itemid) return false;
/* 74 */       if (this.price != _o_.price) return false;
/* 75 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.index;
/* 84 */     _h_ += this.itemid;
/* 85 */     _h_ += this.price;
/* 86 */     _h_ += this.iteminfo.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.index).append(",");
/* 94 */     _sb_.append(this.itemid).append(",");
/* 95 */     _sb_.append(this.price).append(",");
/* 96 */     _sb_.append(this.iteminfo).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SQueryItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */