/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.sworn.main.PNewMemberConfirmSwornReq;
/*    */ 
/*    */ 
/*    */ public class CNewMemberConfirmSwornReq
/*    */   extends __CNewMemberConfirmSwornReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597807;
/*    */   public static final int CONFIRM_AGREE = 1;
/*    */   public static final int CONFIRM_NOTAGREE = 2;
/*    */   public int confirm;
/*    */   public String title;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PNewMemberConfirmSwornReq(roleid, this.confirm, this.title));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12597807;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public CNewMemberConfirmSwornReq()
/*    */   {
/* 39 */     this.title = "";
/*    */   }
/*    */   
/*    */   public CNewMemberConfirmSwornReq(int _confirm_, String _title_) {
/* 43 */     this.confirm = _confirm_;
/* 44 */     this.title = _title_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.confirm);
/* 53 */     _os_.marshal(this.title, "UTF-16LE");
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.confirm = _os_.unmarshal_int();
/* 59 */     this.title = _os_.unmarshal_String("UTF-16LE");
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof CNewMemberConfirmSwornReq)) {
/* 69 */       CNewMemberConfirmSwornReq _o_ = (CNewMemberConfirmSwornReq)_o1_;
/* 70 */       if (this.confirm != _o_.confirm) return false;
/* 71 */       if (!this.title.equals(_o_.title)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.confirm;
/* 80 */     _h_ += this.title.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.confirm).append(",");
/* 88 */     _sb_.append("T").append(this.title.length()).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\CNewMemberConfirmSwornReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */