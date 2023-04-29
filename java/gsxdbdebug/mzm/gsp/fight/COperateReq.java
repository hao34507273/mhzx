/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fight.main.POperateReq;
/*    */ 
/*    */ 
/*    */ public class COperateReq
/*    */   extends __COperateReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594193;
/*    */   public int fighterid;
/*    */   public int op_type;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new POperateReq(roleid, this.fighterid, this.op_type, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12594193;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public COperateReq()
/*    */   {
/* 37 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public COperateReq(int _fighterid_, int _op_type_, Octets _content_) {
/* 41 */     this.fighterid = _fighterid_;
/* 42 */     this.op_type = _op_type_;
/* 43 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.fighterid);
/* 52 */     _os_.marshal(this.op_type);
/* 53 */     _os_.marshal(this.content);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.fighterid = _os_.unmarshal_int();
/* 59 */     this.op_type = _os_.unmarshal_int();
/* 60 */     this.content = _os_.unmarshal_Octets();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof COperateReq)) {
/* 70 */       COperateReq _o_ = (COperateReq)_o1_;
/* 71 */       if (this.fighterid != _o_.fighterid) return false;
/* 72 */       if (this.op_type != _o_.op_type) return false;
/* 73 */       if (!this.content.equals(_o_.content)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.fighterid;
/* 82 */     _h_ += this.op_type;
/* 83 */     _h_ += this.content.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.fighterid).append(",");
/* 91 */     _sb_.append(this.op_type).append(",");
/* 92 */     _sb_.append("B").append(this.content.size()).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\COperateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */