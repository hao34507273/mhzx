/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SEquipQiLinRes
/*    */   extends __SEquipQiLinRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584747;
/*    */   public byte issuccess;
/*    */   public int strengthlevel;
/*    */   public ItemInfo iteminfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584747;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEquipQiLinRes()
/*    */   {
/* 33 */     this.iteminfo = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SEquipQiLinRes(byte _issuccess_, int _strengthlevel_, ItemInfo _iteminfo_) {
/* 37 */     this.issuccess = _issuccess_;
/* 38 */     this.strengthlevel = _strengthlevel_;
/* 39 */     this.iteminfo = _iteminfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.iteminfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.issuccess);
/* 49 */     _os_.marshal(this.strengthlevel);
/* 50 */     _os_.marshal(this.iteminfo);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.issuccess = _os_.unmarshal_byte();
/* 56 */     this.strengthlevel = _os_.unmarshal_int();
/* 57 */     this.iteminfo.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SEquipQiLinRes)) {
/* 67 */       SEquipQiLinRes _o_ = (SEquipQiLinRes)_o1_;
/* 68 */       if (this.issuccess != _o_.issuccess) return false;
/* 69 */       if (this.strengthlevel != _o_.strengthlevel) return false;
/* 70 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.issuccess;
/* 79 */     _h_ += this.strengthlevel;
/* 80 */     _h_ += this.iteminfo.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.issuccess).append(",");
/* 88 */     _sb_.append(this.strengthlevel).append(",");
/* 89 */     _sb_.append(this.iteminfo).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SEquipQiLinRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */