/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.team.main.PAdjustDisposition;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAdjustDisposition
/*    */   extends __CAdjustDisposition__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588324;
/*    */   public int srcpos;
/*    */   public int dstpos;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleid, new PAdjustDisposition(roleid, this.srcpos, this.dstpos));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12588324;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAdjustDisposition() {}
/*    */   
/*    */ 
/*    */   public CAdjustDisposition(int _srcpos_, int _dstpos_)
/*    */   {
/* 41 */     this.srcpos = _srcpos_;
/* 42 */     this.dstpos = _dstpos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.srcpos);
/* 51 */     _os_.marshal(this.dstpos);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.srcpos = _os_.unmarshal_int();
/* 57 */     this.dstpos = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CAdjustDisposition)) {
/* 67 */       CAdjustDisposition _o_ = (CAdjustDisposition)_o1_;
/* 68 */       if (this.srcpos != _o_.srcpos) return false;
/* 69 */       if (this.dstpos != _o_.dstpos) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.srcpos;
/* 78 */     _h_ += this.dstpos;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.srcpos).append(",");
/* 86 */     _sb_.append(this.dstpos).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAdjustDisposition _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.srcpos - _o_.srcpos;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.dstpos - _o_.dstpos;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\CAdjustDisposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */