/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PGetReceiveFlowerRank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetReceiveFlowerPointRankReq
/*    */   extends __CGetReceiveFlowerPointRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584796;
/*    */   public int startpos;
/*    */   public int num;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PGetReceiveFlowerRank(roleid, this.startpos, this.num));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12584796;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetReceiveFlowerPointRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetReceiveFlowerPointRankReq(int _startpos_, int _num_)
/*    */   {
/* 39 */     this.startpos = _startpos_;
/* 40 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.startpos);
/* 49 */     _os_.marshal(this.num);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.startpos = _os_.unmarshal_int();
/* 55 */     this.num = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CGetReceiveFlowerPointRankReq)) {
/* 65 */       CGetReceiveFlowerPointRankReq _o_ = (CGetReceiveFlowerPointRankReq)_o1_;
/* 66 */       if (this.startpos != _o_.startpos) return false;
/* 67 */       if (this.num != _o_.num) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.startpos;
/* 76 */     _h_ += this.num;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.startpos).append(",");
/* 84 */     _sb_.append(this.num).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetReceiveFlowerPointRankReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.startpos - _o_.startpos;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.num - _o_.num;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CGetReceiveFlowerPointRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */