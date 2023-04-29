/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PRenamePet;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRenamePetReq
/*    */   extends __CRenamePetReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590601;
/*    */   public long petid;
/*    */   public String petname;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PRenamePet(this.petid, roleId, this.petname));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12590601;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CRenamePetReq()
/*    */   {
/* 38 */     this.petname = "";
/*    */   }
/*    */   
/*    */   public CRenamePetReq(long _petid_, String _petname_) {
/* 42 */     this.petid = _petid_;
/* 43 */     this.petname = _petname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.petid);
/* 52 */     _os_.marshal(this.petname, "UTF-16LE");
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.petid = _os_.unmarshal_long();
/* 58 */     this.petname = _os_.unmarshal_String("UTF-16LE");
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CRenamePetReq)) {
/* 68 */       CRenamePetReq _o_ = (CRenamePetReq)_o1_;
/* 69 */       if (this.petid != _o_.petid) return false;
/* 70 */       if (!this.petname.equals(_o_.petname)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.petid;
/* 79 */     _h_ += this.petname.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.petid).append(",");
/* 87 */     _sb_.append("T").append(this.petname.length()).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CRenamePetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */