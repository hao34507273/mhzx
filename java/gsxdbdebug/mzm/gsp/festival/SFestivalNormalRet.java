/*    */ package mzm.gsp.festival;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SFestivalNormalRet
/*    */   extends __SFestivalNormalRet__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600071;
/*    */   public static final int TAKE_FESTIVAL_AWARD_NOT_IN_FESTIVAL_TIME = 0;
/*    */   public static final int TAKE_FESTIVAL_AWARD_BAG_FULL = 1;
/*    */   public static final int TAKE_FESTIVAL_AWARD_UNKNOW = 3;
/*    */   public int ret;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600071;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFestivalNormalRet()
/*    */   {
/* 38 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SFestivalNormalRet(int _ret_, ArrayList<String> _args_) {
/* 42 */     this.ret = _ret_;
/* 43 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.ret);
/* 52 */     _os_.compact_uint32(this.args.size());
/* 53 */     for (String _v_ : this.args) {
/* 54 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.ret = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 64 */       this.args.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SFestivalNormalRet)) {
/* 75 */       SFestivalNormalRet _o_ = (SFestivalNormalRet)_o1_;
/* 76 */       if (this.ret != _o_.ret) return false;
/* 77 */       if (!this.args.equals(_o_.args)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.ret;
/* 86 */     _h_ += this.args.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.ret).append(",");
/* 94 */     _sb_.append(this.args).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\SFestivalNormalRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */