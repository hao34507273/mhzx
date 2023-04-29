/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RemovePointRaceContext
/*    */   implements Marshal
/*    */ {
/*    */   public static final int REMOVE_POINT_RACE_DATA = 1;
/*    */   public int oper_type;
/*    */   public Octets content;
/*    */   
/*    */   public RemovePointRaceContext()
/*    */   {
/* 17 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public RemovePointRaceContext(int _oper_type_, Octets _content_) {
/* 21 */     this.oper_type = _oper_type_;
/* 22 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.oper_type);
/* 31 */     _os_.marshal(this.content);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.oper_type = _os_.unmarshal_int();
/* 37 */     this.content = _os_.unmarshal_Octets();
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof RemovePointRaceContext)) {
/* 44 */       RemovePointRaceContext _o_ = (RemovePointRaceContext)_o1_;
/* 45 */       if (this.oper_type != _o_.oper_type) return false;
/* 46 */       if (!this.content.equals(_o_.content)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.oper_type;
/* 55 */     _h_ += this.content.hashCode();
/* 56 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 60 */     StringBuilder _sb_ = new StringBuilder();
/* 61 */     _sb_.append("(");
/* 62 */     _sb_.append(this.oper_type).append(",");
/* 63 */     _sb_.append("B").append(this.content.size()).append(",");
/* 64 */     _sb_.append(")");
/* 65 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\RemovePointRaceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */