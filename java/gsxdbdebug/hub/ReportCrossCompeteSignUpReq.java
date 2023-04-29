/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class ReportCrossCompeteSignUpReq
/*    */   implements Marshal
/*    */ {
/*    */   public static final int MATCH_TYPE_NORMAL = 0;
/*    */   public static final int MATCH_TYPE_FORCE = 1;
/*    */   public long start_millis;
/*    */   public int zoneid;
/*    */   public int server_level;
/*    */   public ArrayList<CrossCompeteSignUpFaction> factions;
/*    */   public int match_type;
/*    */   
/*    */   public ReportCrossCompeteSignUpReq()
/*    */   {
/* 21 */     this.factions = new ArrayList();
/*    */   }
/*    */   
/*    */   public ReportCrossCompeteSignUpReq(long _start_millis_, int _zoneid_, int _server_level_, ArrayList<CrossCompeteSignUpFaction> _factions_, int _match_type_) {
/* 25 */     this.start_millis = _start_millis_;
/* 26 */     this.zoneid = _zoneid_;
/* 27 */     this.server_level = _server_level_;
/* 28 */     this.factions = _factions_;
/* 29 */     this.match_type = _match_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     for (CrossCompeteSignUpFaction _v_ : this.factions)
/* 34 */       if (!_v_._validator_()) return false;
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.start_millis);
/* 40 */     _os_.marshal(this.zoneid);
/* 41 */     _os_.marshal(this.server_level);
/* 42 */     _os_.compact_uint32(this.factions.size());
/* 43 */     for (CrossCompeteSignUpFaction _v_ : this.factions) {
/* 44 */       _os_.marshal(_v_);
/*    */     }
/* 46 */     _os_.marshal(this.match_type);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.start_millis = _os_.unmarshal_long();
/* 52 */     this.zoneid = _os_.unmarshal_int();
/* 53 */     this.server_level = _os_.unmarshal_int();
/* 54 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 55 */       CrossCompeteSignUpFaction _v_ = new CrossCompeteSignUpFaction();
/* 56 */       _v_.unmarshal(_os_);
/* 57 */       this.factions.add(_v_);
/*    */     }
/* 59 */     this.match_type = _os_.unmarshal_int();
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof ReportCrossCompeteSignUpReq)) {
/* 66 */       ReportCrossCompeteSignUpReq _o_ = (ReportCrossCompeteSignUpReq)_o1_;
/* 67 */       if (this.start_millis != _o_.start_millis) return false;
/* 68 */       if (this.zoneid != _o_.zoneid) return false;
/* 69 */       if (this.server_level != _o_.server_level) return false;
/* 70 */       if (!this.factions.equals(_o_.factions)) return false;
/* 71 */       if (this.match_type != _o_.match_type) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.start_millis;
/* 80 */     _h_ += this.zoneid;
/* 81 */     _h_ += this.server_level;
/* 82 */     _h_ += this.factions.hashCode();
/* 83 */     _h_ += this.match_type;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.start_millis).append(",");
/* 91 */     _sb_.append(this.zoneid).append(",");
/* 92 */     _sb_.append(this.server_level).append(",");
/* 93 */     _sb_.append(this.factions).append(",");
/* 94 */     _sb_.append(this.match_type).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ReportCrossCompeteSignUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */