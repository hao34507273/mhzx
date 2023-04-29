/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class EnterCrossCompeteMapRsp
/*    */   implements Marshal
/*    */ {
/*    */   public static final int RESULT_SUCCESS = 0;
/*    */   public static final int RESULT_NO_FACTION = 1;
/*    */   public static final int RESULT_INVALID_MEMBER = 2;
/*    */   public static final int RESULT_NO_COMPETE = 3;
/*    */   public static final int RESULT_INVALID_STAGE = 4;
/*    */   public static final int RESULT_INVALID_TEAM_STATUS = 5;
/*    */   public static final int RESULT_EXCEPTION = 6;
/*    */   public long contextid;
/*    */   public int result;
/*    */   public ArrayList<Long> invalid_roles;
/*    */   
/*    */   public EnterCrossCompeteMapRsp()
/*    */   {
/* 24 */     this.invalid_roles = new ArrayList();
/*    */   }
/*    */   
/*    */   public EnterCrossCompeteMapRsp(long _contextid_, int _result_, ArrayList<Long> _invalid_roles_) {
/* 28 */     this.contextid = _contextid_;
/* 29 */     this.result = _result_;
/* 30 */     this.invalid_roles = _invalid_roles_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.contextid);
/* 39 */     _os_.marshal(this.result);
/* 40 */     _os_.compact_uint32(this.invalid_roles.size());
/* 41 */     for (Long _v_ : this.invalid_roles) {
/* 42 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.contextid = _os_.unmarshal_long();
/* 49 */     this.result = _os_.unmarshal_int();
/* 50 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 52 */       long _v_ = _os_.unmarshal_long();
/* 53 */       this.invalid_roles.add(Long.valueOf(_v_));
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof EnterCrossCompeteMapRsp)) {
/* 61 */       EnterCrossCompeteMapRsp _o_ = (EnterCrossCompeteMapRsp)_o1_;
/* 62 */       if (this.contextid != _o_.contextid) return false;
/* 63 */       if (this.result != _o_.result) return false;
/* 64 */       if (!this.invalid_roles.equals(_o_.invalid_roles)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.contextid;
/* 73 */     _h_ += this.result;
/* 74 */     _h_ += this.invalid_roles.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.contextid).append(",");
/* 82 */     _sb_.append(this.result).append(",");
/* 83 */     _sb_.append(this.invalid_roles).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\EnterCrossCompeteMapRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */