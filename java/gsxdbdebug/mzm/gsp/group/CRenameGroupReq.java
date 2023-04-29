/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.group.main.PRenameGroupReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRenameGroupReq
/*    */   extends __CRenameGroupReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605189;
/*    */   public long groupid;
/*    */   public Octets new_group_name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PRenameGroupReq(roleid, this.groupid, this.new_group_name));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12605189;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CRenameGroupReq()
/*    */   {
/* 38 */     this.new_group_name = new Octets();
/*    */   }
/*    */   
/*    */   public CRenameGroupReq(long _groupid_, Octets _new_group_name_) {
/* 42 */     this.groupid = _groupid_;
/* 43 */     this.new_group_name = _new_group_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.groupid);
/* 52 */     _os_.marshal(this.new_group_name);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.groupid = _os_.unmarshal_long();
/* 58 */     this.new_group_name = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CRenameGroupReq)) {
/* 68 */       CRenameGroupReq _o_ = (CRenameGroupReq)_o1_;
/* 69 */       if (this.groupid != _o_.groupid) return false;
/* 70 */       if (!this.new_group_name.equals(_o_.new_group_name)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.groupid;
/* 79 */     _h_ += this.new_group_name.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.groupid).append(",");
/* 87 */     _sb_.append("B").append(this.new_group_name.size()).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\CRenameGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */