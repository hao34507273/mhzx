/*    */ package mzm.gsp.ladder;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GetLadderRoleRankContext implements Marshal
/*    */ {
/*    */   public static final int OPER_TYPE_SELF_REQ = 0;
/*    */   public int oper_type;
/*    */   public int count;
/*    */   public Octets content;
/*    */   
/*    */   public GetLadderRoleRankContext()
/*    */   {
/* 16 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public GetLadderRoleRankContext(int _oper_type_, int _count_, Octets _content_) {
/* 20 */     this.oper_type = _oper_type_;
/* 21 */     this.count = _count_;
/* 22 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.oper_type);
/* 31 */     _os_.marshal(this.count);
/* 32 */     _os_.marshal(this.content);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 37 */     this.oper_type = _os_.unmarshal_int();
/* 38 */     this.count = _os_.unmarshal_int();
/* 39 */     this.content = _os_.unmarshal_Octets();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof GetLadderRoleRankContext)) {
/* 46 */       GetLadderRoleRankContext _o_ = (GetLadderRoleRankContext)_o1_;
/* 47 */       if (this.oper_type != _o_.oper_type) return false;
/* 48 */       if (this.count != _o_.count) return false;
/* 49 */       if (!this.content.equals(_o_.content)) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.oper_type;
/* 58 */     _h_ += this.count;
/* 59 */     _h_ += this.content.hashCode();
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.oper_type).append(",");
/* 67 */     _sb_.append(this.count).append(",");
/* 68 */     _sb_.append("B").append(this.content.size()).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\GetLadderRoleRankContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */