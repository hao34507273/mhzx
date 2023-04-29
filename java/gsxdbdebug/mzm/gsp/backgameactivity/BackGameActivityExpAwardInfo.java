/*    */ package mzm.gsp.backgameactivity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class BackGameActivityExpAwardInfo implements Marshal
/*    */ {
/*    */   public int login_count;
/*    */   public ArrayList<Integer> already_get_exp_awards;
/*    */   
/*    */   public BackGameActivityExpAwardInfo()
/*    */   {
/* 15 */     this.already_get_exp_awards = new ArrayList();
/*    */   }
/*    */   
/*    */   public BackGameActivityExpAwardInfo(int _login_count_, ArrayList<Integer> _already_get_exp_awards_) {
/* 19 */     this.login_count = _login_count_;
/* 20 */     this.already_get_exp_awards = _already_get_exp_awards_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.login_count);
/* 29 */     _os_.compact_uint32(this.already_get_exp_awards.size());
/* 30 */     for (Integer _v_ : this.already_get_exp_awards) {
/* 31 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.login_count = _os_.unmarshal_int();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 40 */       int _v_ = _os_.unmarshal_int();
/* 41 */       this.already_get_exp_awards.add(Integer.valueOf(_v_));
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof BackGameActivityExpAwardInfo)) {
/* 49 */       BackGameActivityExpAwardInfo _o_ = (BackGameActivityExpAwardInfo)_o1_;
/* 50 */       if (this.login_count != _o_.login_count) return false;
/* 51 */       if (!this.already_get_exp_awards.equals(_o_.already_get_exp_awards)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.login_count;
/* 60 */     _h_ += this.already_get_exp_awards.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.login_count).append(",");
/* 68 */     _sb_.append(this.already_get_exp_awards).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\BackGameActivityExpAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */