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
/*    */ 
/*    */ public class SSynEquipQiLinOperateRes
/*    */   extends __SSynEquipQiLinOperateRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584855;
/*    */   public int strengthlevel;
/*    */   public ItemInfo iteminfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584855;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynEquipQiLinOperateRes()
/*    */   {
/* 32 */     this.iteminfo = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SSynEquipQiLinOperateRes(int _strengthlevel_, ItemInfo _iteminfo_) {
/* 36 */     this.strengthlevel = _strengthlevel_;
/* 37 */     this.iteminfo = _iteminfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.iteminfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.strengthlevel);
/* 47 */     _os_.marshal(this.iteminfo);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.strengthlevel = _os_.unmarshal_int();
/* 53 */     this.iteminfo.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynEquipQiLinOperateRes)) {
/* 63 */       SSynEquipQiLinOperateRes _o_ = (SSynEquipQiLinOperateRes)_o1_;
/* 64 */       if (this.strengthlevel != _o_.strengthlevel) return false;
/* 65 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.strengthlevel;
/* 74 */     _h_ += this.iteminfo.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.strengthlevel).append(",");
/* 82 */     _sb_.append(this.iteminfo).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SSynEquipQiLinOperateRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */