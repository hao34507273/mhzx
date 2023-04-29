/*    */ package mzm.gsp.npc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.npc.main.PCNpcFightService;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CNPCFightService
/*    */   extends __CNPCFightService__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586758;
/*    */   public int npcid;
/*    */   public int serviceid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCNpcFightService(roleid, this.npcid, this.serviceid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12586758;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CNPCFightService() {}
/*    */   
/*    */ 
/*    */   public CNPCFightService(int _npcid_, int _serviceid_)
/*    */   {
/* 39 */     this.npcid = _npcid_;
/* 40 */     this.serviceid = _serviceid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.npcid);
/* 49 */     _os_.marshal(this.serviceid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.npcid = _os_.unmarshal_int();
/* 55 */     this.serviceid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CNPCFightService)) {
/* 65 */       CNPCFightService _o_ = (CNPCFightService)_o1_;
/* 66 */       if (this.npcid != _o_.npcid) return false;
/* 67 */       if (this.serviceid != _o_.serviceid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.npcid;
/* 76 */     _h_ += this.serviceid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.npcid).append(",");
/* 84 */     _sb_.append(this.serviceid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CNPCFightService _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.npcid - _o_.npcid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.serviceid - _o_.serviceid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\CNPCFightService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */