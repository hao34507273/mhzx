/*    */ package mzm.gsp.ladder;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GetLadderRankRangeContext implements Marshal
/*    */ {
/*    */   public static final int OPER_TYPE_CLIENT_REQ = 0;
/*    */   public static final int OPER_TYPE_SEND_RANK_AWARD = 1;
/*    */   public int oper_type;
/*    */   public int count;
/*    */   public Octets content;
/*    */   
/*    */   public GetLadderRankRangeContext()
/*    */   {
/* 17 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public GetLadderRankRangeContext(int _oper_type_, int _count_, Octets _content_) {
/* 21 */     this.oper_type = _oper_type_;
/* 22 */     this.count = _count_;
/* 23 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.oper_type);
/* 32 */     _os_.marshal(this.count);
/* 33 */     _os_.marshal(this.content);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.oper_type = _os_.unmarshal_int();
/* 39 */     this.count = _os_.unmarshal_int();
/* 40 */     this.content = _os_.unmarshal_Octets();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof GetLadderRankRangeContext)) {
/* 47 */       GetLadderRankRangeContext _o_ = (GetLadderRankRangeContext)_o1_;
/* 48 */       if (this.oper_type != _o_.oper_type) return false;
/* 49 */       if (this.count != _o_.count) return false;
/* 50 */       if (!this.content.equals(_o_.content)) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.oper_type;
/* 59 */     _h_ += this.count;
/* 60 */     _h_ += this.content.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.oper_type).append(",");
/* 68 */     _sb_.append(this.count).append(",");
/* 69 */     _sb_.append("B").append(this.content.size()).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\GetLadderRankRangeContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */