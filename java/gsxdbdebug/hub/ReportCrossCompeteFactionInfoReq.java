/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class ReportCrossCompeteFactionInfoReq implements Marshal
/*    */ {
/*    */   public long factionid;
/*    */   public String name;
/*    */   public ArrayList<CrossCompeteFactionDutyMembers> members;
/*    */   public int design_titleid;
/*    */   public int partcipate_count;
/*    */   
/*    */   public ReportCrossCompeteFactionInfoReq()
/*    */   {
/* 18 */     this.name = "";
/* 19 */     this.members = new ArrayList();
/*    */   }
/*    */   
/*    */   public ReportCrossCompeteFactionInfoReq(long _factionid_, String _name_, ArrayList<CrossCompeteFactionDutyMembers> _members_, int _design_titleid_, int _partcipate_count_) {
/* 23 */     this.factionid = _factionid_;
/* 24 */     this.name = _name_;
/* 25 */     this.members = _members_;
/* 26 */     this.design_titleid = _design_titleid_;
/* 27 */     this.partcipate_count = _partcipate_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     for (CrossCompeteFactionDutyMembers _v_ : this.members)
/* 32 */       if (!_v_._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.factionid);
/* 38 */     _os_.marshal(this.name, "UTF-16LE");
/* 39 */     _os_.compact_uint32(this.members.size());
/* 40 */     for (CrossCompeteFactionDutyMembers _v_ : this.members) {
/* 41 */       _os_.marshal(_v_);
/*    */     }
/* 43 */     _os_.marshal(this.design_titleid);
/* 44 */     _os_.marshal(this.partcipate_count);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.factionid = _os_.unmarshal_long();
/* 50 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 51 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 52 */       CrossCompeteFactionDutyMembers _v_ = new CrossCompeteFactionDutyMembers();
/* 53 */       _v_.unmarshal(_os_);
/* 54 */       this.members.add(_v_);
/*    */     }
/* 56 */     this.design_titleid = _os_.unmarshal_int();
/* 57 */     this.partcipate_count = _os_.unmarshal_int();
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof ReportCrossCompeteFactionInfoReq)) {
/* 64 */       ReportCrossCompeteFactionInfoReq _o_ = (ReportCrossCompeteFactionInfoReq)_o1_;
/* 65 */       if (this.factionid != _o_.factionid) return false;
/* 66 */       if (!this.name.equals(_o_.name)) return false;
/* 67 */       if (!this.members.equals(_o_.members)) return false;
/* 68 */       if (this.design_titleid != _o_.design_titleid) return false;
/* 69 */       if (this.partcipate_count != _o_.partcipate_count) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.factionid;
/* 78 */     _h_ += this.name.hashCode();
/* 79 */     _h_ += this.members.hashCode();
/* 80 */     _h_ += this.design_titleid;
/* 81 */     _h_ += this.partcipate_count;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.factionid).append(",");
/* 89 */     _sb_.append("T").append(this.name.length()).append(",");
/* 90 */     _sb_.append(this.members).append(",");
/* 91 */     _sb_.append(this.design_titleid).append(",");
/* 92 */     _sb_.append(this.partcipate_count).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ReportCrossCompeteFactionInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */