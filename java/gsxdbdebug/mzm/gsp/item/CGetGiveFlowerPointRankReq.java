/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PGetGiveFlowerRank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetGiveFlowerPointRankReq
/*    */   extends __CGetGiveFlowerPointRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584799;
/*    */   public int startpos;
/*    */   public int num;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PGetGiveFlowerRank(roleid, this.startpos, this.num));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584799;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetGiveFlowerPointRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetGiveFlowerPointRankReq(int _startpos_, int _num_)
/*    */   {
/* 40 */     this.startpos = _startpos_;
/* 41 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.startpos);
/* 50 */     _os_.marshal(this.num);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.startpos = _os_.unmarshal_int();
/* 56 */     this.num = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CGetGiveFlowerPointRankReq)) {
/* 66 */       CGetGiveFlowerPointRankReq _o_ = (CGetGiveFlowerPointRankReq)_o1_;
/* 67 */       if (this.startpos != _o_.startpos) return false;
/* 68 */       if (this.num != _o_.num) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.startpos;
/* 77 */     _h_ += this.num;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.startpos).append(",");
/* 85 */     _sb_.append(this.num).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetGiveFlowerPointRankReq _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.startpos - _o_.startpos;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.num - _o_.num;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CGetGiveFlowerPointRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */