/*    */ package mzm.gsp.signaward;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.signaward.main.PCSignPreciousOpenLuckyBox;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSignPreciousOpenLuckyBox
/*    */   extends __CSignPreciousOpenLuckyBox__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593425;
/*    */   public long current_yuan_bao_num;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCSignPreciousOpenLuckyBox(roleId, this.current_yuan_bao_num));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12593425;
/*    */   }
/*    */   
/*    */ 
/*    */   public CSignPreciousOpenLuckyBox() {}
/*    */   
/*    */ 
/*    */   public CSignPreciousOpenLuckyBox(long _current_yuan_bao_num_)
/*    */   {
/* 43 */     this.current_yuan_bao_num = _current_yuan_bao_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.current_yuan_bao_num);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.current_yuan_bao_num = _os_.unmarshal_long();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CSignPreciousOpenLuckyBox)) {
/* 66 */       CSignPreciousOpenLuckyBox _o_ = (CSignPreciousOpenLuckyBox)_o1_;
/* 67 */       if (this.current_yuan_bao_num != _o_.current_yuan_bao_num) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.current_yuan_bao_num;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.current_yuan_bao_num).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSignPreciousOpenLuckyBox _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.current_yuan_bao_num - _o_.current_yuan_bao_num);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\CSignPreciousOpenLuckyBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */