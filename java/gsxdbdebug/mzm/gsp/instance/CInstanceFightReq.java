/*    */ package mzm.gsp.instance;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.instance.main.PCSingleInstanceFight;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CInstanceFightReq
/*    */   extends __CInstanceFightReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591377;
/*    */   public int monsterinstanceid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCSingleInstanceFight(roleid, this.monsterinstanceid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12591377;
/*    */   }
/*    */   
/*    */ 
/*    */   public CInstanceFightReq() {}
/*    */   
/*    */ 
/*    */   public CInstanceFightReq(int _monsterinstanceid_)
/*    */   {
/* 38 */     this.monsterinstanceid = _monsterinstanceid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.monsterinstanceid);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.monsterinstanceid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CInstanceFightReq)) {
/* 61 */       CInstanceFightReq _o_ = (CInstanceFightReq)_o1_;
/* 62 */       if (this.monsterinstanceid != _o_.monsterinstanceid) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.monsterinstanceid;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.monsterinstanceid).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CInstanceFightReq _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = this.monsterinstanceid - _o_.monsterinstanceid;
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\CInstanceFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */