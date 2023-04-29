/*    */ package mzm.gsp.title;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class AppellationInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int appellationid;
/*    */   public ArrayList<String> appargs;
/*    */   public long timeout;
/*    */   
/*    */   public AppellationInfo()
/*    */   {
/* 14 */     this.appargs = new ArrayList();
/* 15 */     this.timeout = 0L;
/*    */   }
/*    */   
/*    */   public AppellationInfo(int _appellationid_, ArrayList<String> _appargs_, long _timeout_) {
/* 19 */     this.appellationid = _appellationid_;
/* 20 */     this.appargs = _appargs_;
/* 21 */     this.timeout = _timeout_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.appellationid);
/* 30 */     _os_.compact_uint32(this.appargs.size());
/* 31 */     for (String _v_ : this.appargs) {
/* 32 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 34 */     _os_.marshal(this.timeout);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 39 */     this.appellationid = _os_.unmarshal_int();
/* 40 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 42 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 43 */       this.appargs.add(_v_);
/*    */     }
/* 45 */     this.timeout = _os_.unmarshal_long();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof AppellationInfo)) {
/* 52 */       AppellationInfo _o_ = (AppellationInfo)_o1_;
/* 53 */       if (this.appellationid != _o_.appellationid) return false;
/* 54 */       if (!this.appargs.equals(_o_.appargs)) return false;
/* 55 */       if (this.timeout != _o_.timeout) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.appellationid;
/* 64 */     _h_ += this.appargs.hashCode();
/* 65 */     _h_ += (int)this.timeout;
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append(this.appellationid).append(",");
/* 73 */     _sb_.append(this.appargs).append(",");
/* 74 */     _sb_.append(this.timeout).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\AppellationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */