/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.children.main.PAutoBreedBabyReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAutoBreedBabyReq
/*    */   extends __CAutoBreedBabyReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609437;
/*    */   public long childid;
/*    */   public long client_yuanbao;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid > 0L) {
/* 21 */       Role.addRoleProcedure(roleid, new PAutoBreedBabyReq(roleid, this.childid, this.client_yuanbao));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12609437;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAutoBreedBabyReq() {}
/*    */   
/*    */ 
/*    */   public CAutoBreedBabyReq(long _childid_, long _client_yuanbao_)
/*    */   {
/* 42 */     this.childid = _childid_;
/* 43 */     this.client_yuanbao = _client_yuanbao_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.childid);
/* 52 */     _os_.marshal(this.client_yuanbao);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.childid = _os_.unmarshal_long();
/* 58 */     this.client_yuanbao = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CAutoBreedBabyReq)) {
/* 68 */       CAutoBreedBabyReq _o_ = (CAutoBreedBabyReq)_o1_;
/* 69 */       if (this.childid != _o_.childid) return false;
/* 70 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.childid;
/* 79 */     _h_ += (int)this.client_yuanbao;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.childid).append(",");
/* 87 */     _sb_.append(this.client_yuanbao).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAutoBreedBabyReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CAutoBreedBabyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */