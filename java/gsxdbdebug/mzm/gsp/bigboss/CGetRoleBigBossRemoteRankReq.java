/*    */ package mzm.gsp.bigboss;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.bigboss.main.PCGetRoleBigBossRemoteRank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRoleBigBossRemoteRankReq
/*    */   extends __CGetRoleBigBossRemoteRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598033;
/*    */   public int occupation;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCGetRoleBigBossRemoteRank(roleid, this.occupation));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12598033;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRoleBigBossRemoteRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetRoleBigBossRemoteRankReq(int _occupation_)
/*    */   {
/* 41 */     this.occupation = _occupation_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.occupation);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.occupation = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CGetRoleBigBossRemoteRankReq)) {
/* 64 */       CGetRoleBigBossRemoteRankReq _o_ = (CGetRoleBigBossRemoteRankReq)_o1_;
/* 65 */       if (this.occupation != _o_.occupation) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.occupation;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.occupation).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRoleBigBossRemoteRankReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.occupation - _o_.occupation;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\CGetRoleBigBossRemoteRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */