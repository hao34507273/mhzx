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
/*    */ public class SEquipMakeRes
/*    */   extends __SEquipMakeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584749;
/*    */   public int key;
/*    */   public ItemInfo eqpinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584749;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SEquipMakeRes()
/*    */   {
/* 32 */     this.eqpinfo = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SEquipMakeRes(int _key_, ItemInfo _eqpinfo_) {
/* 36 */     this.key = _key_;
/* 37 */     this.eqpinfo = _eqpinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.eqpinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.key);
/* 47 */     _os_.marshal(this.eqpinfo);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.key = _os_.unmarshal_int();
/* 53 */     this.eqpinfo.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SEquipMakeRes)) {
/* 63 */       SEquipMakeRes _o_ = (SEquipMakeRes)_o1_;
/* 64 */       if (this.key != _o_.key) return false;
/* 65 */       if (!this.eqpinfo.equals(_o_.eqpinfo)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.key;
/* 74 */     _h_ += this.eqpinfo.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.key).append(",");
/* 82 */     _sb_.append(this.eqpinfo).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SEquipMakeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */