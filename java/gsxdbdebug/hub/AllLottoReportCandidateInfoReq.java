/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class AllLottoReportCandidateInfoReq implements Marshal
/*    */ {
/*    */   public ArrayList<Integer> zoneids;
/*    */   public int activity_cfg_id;
/*    */   public int turn;
/*    */   public AllLottoRoleInfo candidate_info;
/*    */   
/*    */   public AllLottoReportCandidateInfoReq()
/*    */   {
/* 17 */     this.zoneids = new ArrayList();
/* 18 */     this.candidate_info = new AllLottoRoleInfo();
/*    */   }
/*    */   
/*    */   public AllLottoReportCandidateInfoReq(ArrayList<Integer> _zoneids_, int _activity_cfg_id_, int _turn_, AllLottoRoleInfo _candidate_info_) {
/* 22 */     this.zoneids = _zoneids_;
/* 23 */     this.activity_cfg_id = _activity_cfg_id_;
/* 24 */     this.turn = _turn_;
/* 25 */     this.candidate_info = _candidate_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     if (!this.candidate_info._validator_()) return false;
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.compact_uint32(this.zoneids.size());
/* 35 */     for (Integer _v_ : this.zoneids) {
/* 36 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 38 */     _os_.marshal(this.activity_cfg_id);
/* 39 */     _os_.marshal(this.turn);
/* 40 */     _os_.marshal(this.candidate_info);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 47 */       int _v_ = _os_.unmarshal_int();
/* 48 */       this.zoneids.add(Integer.valueOf(_v_));
/*    */     }
/* 50 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 51 */     this.turn = _os_.unmarshal_int();
/* 52 */     this.candidate_info.unmarshal(_os_);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof AllLottoReportCandidateInfoReq)) {
/* 59 */       AllLottoReportCandidateInfoReq _o_ = (AllLottoReportCandidateInfoReq)_o1_;
/* 60 */       if (!this.zoneids.equals(_o_.zoneids)) return false;
/* 61 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 62 */       if (this.turn != _o_.turn) return false;
/* 63 */       if (!this.candidate_info.equals(_o_.candidate_info)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.zoneids.hashCode();
/* 72 */     _h_ += this.activity_cfg_id;
/* 73 */     _h_ += this.turn;
/* 74 */     _h_ += this.candidate_info.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.zoneids).append(",");
/* 82 */     _sb_.append(this.activity_cfg_id).append(",");
/* 83 */     _sb_.append(this.turn).append(",");
/* 84 */     _sb_.append(this.candidate_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\AllLottoReportCandidateInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */