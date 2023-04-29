/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class CrossBattleOwn extends XBean implements xbean.CrossBattleOwn
/*      */ {
/*      */   private int stage;
/*      */   private HashMap<Long, xbean.AttendCorpsInfo> attend_corps_infos;
/*      */   private ArrayList<Long> vote_stage_direct_promotion_corps_list;
/*      */   private ArrayList<Long> round_robin_point_rank_list;
/*      */   private int round_robin_round_index;
/*      */   private ArrayList<xbean.RoundRobinRoundInfo> round_robin_round_infos;
/*      */   private ArrayList<Long> round_robin_stage_promotion_corps_list;
/*      */   private boolean report_result_success;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.stage = -1;
/*   33 */     this.attend_corps_infos.clear();
/*   34 */     this.vote_stage_direct_promotion_corps_list.clear();
/*   35 */     this.round_robin_point_rank_list.clear();
/*   36 */     this.round_robin_round_index = 0;
/*   37 */     this.round_robin_round_infos.clear();
/*   38 */     this.round_robin_stage_promotion_corps_list.clear();
/*   39 */     this.report_result_success = false;
/*      */   }
/*      */   
/*      */   CrossBattleOwn(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.stage = -1;
/*   46 */     this.attend_corps_infos = new HashMap();
/*   47 */     this.vote_stage_direct_promotion_corps_list = new ArrayList();
/*   48 */     this.round_robin_point_rank_list = new ArrayList();
/*   49 */     this.round_robin_round_index = 0;
/*   50 */     this.round_robin_round_infos = new ArrayList();
/*   51 */     this.round_robin_stage_promotion_corps_list = new ArrayList();
/*   52 */     this.report_result_success = false;
/*      */   }
/*      */   
/*      */   public CrossBattleOwn()
/*      */   {
/*   57 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CrossBattleOwn(CrossBattleOwn _o_)
/*      */   {
/*   62 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CrossBattleOwn(xbean.CrossBattleOwn _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   67 */     super(_xp_, _vn_);
/*   68 */     if ((_o1_ instanceof CrossBattleOwn)) { assign((CrossBattleOwn)_o1_);
/*   69 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   70 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   71 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CrossBattleOwn _o_) {
/*   76 */     _o_._xdb_verify_unsafe_();
/*   77 */     this.stage = _o_.stage;
/*   78 */     this.attend_corps_infos = new HashMap();
/*   79 */     for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : _o_.attend_corps_infos.entrySet())
/*   80 */       this.attend_corps_infos.put(_e_.getKey(), new AttendCorpsInfo((xbean.AttendCorpsInfo)_e_.getValue(), this, "attend_corps_infos"));
/*   81 */     this.vote_stage_direct_promotion_corps_list = new ArrayList();
/*   82 */     this.vote_stage_direct_promotion_corps_list.addAll(_o_.vote_stage_direct_promotion_corps_list);
/*   83 */     this.round_robin_point_rank_list = new ArrayList();
/*   84 */     this.round_robin_point_rank_list.addAll(_o_.round_robin_point_rank_list);
/*   85 */     this.round_robin_round_index = _o_.round_robin_round_index;
/*   86 */     this.round_robin_round_infos = new ArrayList();
/*   87 */     for (xbean.RoundRobinRoundInfo _v_ : _o_.round_robin_round_infos)
/*   88 */       this.round_robin_round_infos.add(new RoundRobinRoundInfo(_v_, this, "round_robin_round_infos"));
/*   89 */     this.round_robin_stage_promotion_corps_list = new ArrayList();
/*   90 */     this.round_robin_stage_promotion_corps_list.addAll(_o_.round_robin_stage_promotion_corps_list);
/*   91 */     this.report_result_success = _o_.report_result_success;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   96 */     this.stage = _o_.stage;
/*   97 */     this.attend_corps_infos = new HashMap();
/*   98 */     for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : _o_.attend_corps_infos.entrySet())
/*   99 */       this.attend_corps_infos.put(_e_.getKey(), new AttendCorpsInfo((xbean.AttendCorpsInfo)_e_.getValue(), this, "attend_corps_infos"));
/*  100 */     this.vote_stage_direct_promotion_corps_list = new ArrayList();
/*  101 */     this.vote_stage_direct_promotion_corps_list.addAll(_o_.vote_stage_direct_promotion_corps_list);
/*  102 */     this.round_robin_point_rank_list = new ArrayList();
/*  103 */     this.round_robin_point_rank_list.addAll(_o_.round_robin_point_rank_list);
/*  104 */     this.round_robin_round_index = _o_.round_robin_round_index;
/*  105 */     this.round_robin_round_infos = new ArrayList();
/*  106 */     for (xbean.RoundRobinRoundInfo _v_ : _o_.round_robin_round_infos)
/*  107 */       this.round_robin_round_infos.add(new RoundRobinRoundInfo(_v_, this, "round_robin_round_infos"));
/*  108 */     this.round_robin_stage_promotion_corps_list = new ArrayList();
/*  109 */     this.round_robin_stage_promotion_corps_list.addAll(_o_.round_robin_stage_promotion_corps_list);
/*  110 */     this.report_result_success = _o_.report_result_success;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     _os_.marshal(this.stage);
/*  118 */     _os_.compact_uint32(this.attend_corps_infos.size());
/*  119 */     for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : this.attend_corps_infos.entrySet())
/*      */     {
/*  121 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  122 */       ((xbean.AttendCorpsInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  124 */     _os_.compact_uint32(this.vote_stage_direct_promotion_corps_list.size());
/*  125 */     for (Long _v_ : this.vote_stage_direct_promotion_corps_list)
/*      */     {
/*  127 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  129 */     _os_.compact_uint32(this.round_robin_point_rank_list.size());
/*  130 */     for (Long _v_ : this.round_robin_point_rank_list)
/*      */     {
/*  132 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  134 */     _os_.marshal(this.round_robin_round_index);
/*  135 */     _os_.compact_uint32(this.round_robin_round_infos.size());
/*  136 */     for (xbean.RoundRobinRoundInfo _v_ : this.round_robin_round_infos)
/*      */     {
/*  138 */       _v_.marshal(_os_);
/*      */     }
/*  140 */     _os_.compact_uint32(this.round_robin_stage_promotion_corps_list.size());
/*  141 */     for (Long _v_ : this.round_robin_stage_promotion_corps_list)
/*      */     {
/*  143 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  145 */     _os_.marshal(this.report_result_success);
/*  146 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  152 */     _xdb_verify_unsafe_();
/*  153 */     this.stage = _os_.unmarshal_int();
/*      */     
/*  155 */     int size = _os_.uncompact_uint32();
/*  156 */     if (size >= 12)
/*      */     {
/*  158 */       this.attend_corps_infos = new HashMap(size * 2);
/*      */     }
/*  160 */     for (; size > 0; size--)
/*      */     {
/*  162 */       long _k_ = 0L;
/*  163 */       _k_ = _os_.unmarshal_long();
/*  164 */       xbean.AttendCorpsInfo _v_ = new AttendCorpsInfo(0, this, "attend_corps_infos");
/*  165 */       _v_.unmarshal(_os_);
/*  166 */       this.attend_corps_infos.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  169 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  171 */       long _v_ = 0L;
/*  172 */       _v_ = _os_.unmarshal_long();
/*  173 */       this.vote_stage_direct_promotion_corps_list.add(Long.valueOf(_v_));
/*      */     }
/*  175 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  177 */       long _v_ = 0L;
/*  178 */       _v_ = _os_.unmarshal_long();
/*  179 */       this.round_robin_point_rank_list.add(Long.valueOf(_v_));
/*      */     }
/*  181 */     this.round_robin_round_index = _os_.unmarshal_int();
/*  182 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  184 */       xbean.RoundRobinRoundInfo _v_ = new RoundRobinRoundInfo(0, this, "round_robin_round_infos");
/*  185 */       _v_.unmarshal(_os_);
/*  186 */       this.round_robin_round_infos.add(_v_);
/*      */     }
/*  188 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  190 */       long _v_ = 0L;
/*  191 */       _v_ = _os_.unmarshal_long();
/*  192 */       this.round_robin_stage_promotion_corps_list.add(Long.valueOf(_v_));
/*      */     }
/*  194 */     this.report_result_success = _os_.unmarshal_boolean();
/*  195 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  201 */     _xdb_verify_unsafe_();
/*  202 */     int _size_ = 0;
/*  203 */     _size_ += CodedOutputStream.computeInt32Size(1, this.stage);
/*  204 */     for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : this.attend_corps_infos.entrySet())
/*      */     {
/*  206 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  207 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  209 */     for (Long _v_ : this.vote_stage_direct_promotion_corps_list)
/*      */     {
/*  211 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */     }
/*  213 */     for (Long _v_ : this.round_robin_point_rank_list)
/*      */     {
/*  215 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  217 */     _size_ += CodedOutputStream.computeInt32Size(5, this.round_robin_round_index);
/*  218 */     for (xbean.RoundRobinRoundInfo _v_ : this.round_robin_round_infos)
/*      */     {
/*  220 */       _size_ += CodedOutputStream.computeMessageSize(6, _v_);
/*      */     }
/*  222 */     for (Long _v_ : this.round_robin_stage_promotion_corps_list)
/*      */     {
/*  224 */       _size_ += CodedOutputStream.computeInt64Size(7, _v_.longValue());
/*      */     }
/*  226 */     _size_ += CodedOutputStream.computeBoolSize(8, this.report_result_success);
/*  227 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  236 */       _output_.writeInt32(1, this.stage);
/*  237 */       for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : this.attend_corps_infos.entrySet())
/*      */       {
/*  239 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  240 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  242 */       for (Long _v_ : this.vote_stage_direct_promotion_corps_list)
/*      */       {
/*  244 */         _output_.writeInt64(3, _v_.longValue());
/*      */       }
/*  246 */       for (Long _v_ : this.round_robin_point_rank_list)
/*      */       {
/*  248 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*  250 */       _output_.writeInt32(5, this.round_robin_round_index);
/*  251 */       for (xbean.RoundRobinRoundInfo _v_ : this.round_robin_round_infos)
/*      */       {
/*  253 */         _output_.writeMessage(6, _v_);
/*      */       }
/*  255 */       for (Long _v_ : this.round_robin_stage_promotion_corps_list)
/*      */       {
/*  257 */         _output_.writeInt64(7, _v_.longValue());
/*      */       }
/*  259 */       _output_.writeBool(8, this.report_result_success);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  263 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  265 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  274 */       boolean done = false;
/*  275 */       while (!done)
/*      */       {
/*  277 */         int tag = _input_.readTag();
/*  278 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  282 */           done = true;
/*  283 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  287 */           this.stage = _input_.readInt32();
/*  288 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  292 */           long _k_ = 0L;
/*  293 */           _k_ = _input_.readInt64();
/*  294 */           int readTag = _input_.readTag();
/*  295 */           if (18 != readTag)
/*      */           {
/*  297 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  299 */           xbean.AttendCorpsInfo _v_ = new AttendCorpsInfo(0, this, "attend_corps_infos");
/*  300 */           _input_.readMessage(_v_);
/*  301 */           this.attend_corps_infos.put(Long.valueOf(_k_), _v_);
/*  302 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  306 */           long _v_ = 0L;
/*  307 */           _v_ = _input_.readInt64();
/*  308 */           this.vote_stage_direct_promotion_corps_list.add(Long.valueOf(_v_));
/*  309 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  313 */           long _v_ = 0L;
/*  314 */           _v_ = _input_.readInt64();
/*  315 */           this.round_robin_point_rank_list.add(Long.valueOf(_v_));
/*  316 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  320 */           this.round_robin_round_index = _input_.readInt32();
/*  321 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  325 */           xbean.RoundRobinRoundInfo _v_ = new RoundRobinRoundInfo(0, this, "round_robin_round_infos");
/*  326 */           _input_.readMessage(_v_);
/*  327 */           this.round_robin_round_infos.add(_v_);
/*  328 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  332 */           long _v_ = 0L;
/*  333 */           _v_ = _input_.readInt64();
/*  334 */           this.round_robin_stage_promotion_corps_list.add(Long.valueOf(_v_));
/*  335 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  339 */           this.report_result_success = _input_.readBool();
/*  340 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  344 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  346 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  355 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  359 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  361 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossBattleOwn copy()
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     return new CrossBattleOwn(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossBattleOwn toData()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossBattleOwn toBean()
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     return new CrossBattleOwn(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossBattleOwn toDataIf()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossBattleOwn toBeanIf()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStage()
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     return this.stage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.AttendCorpsInfo> getAttend_corps_infos()
/*      */   {
/*  416 */     _xdb_verify_unsafe_();
/*  417 */     return Logs.logMap(new LogKey(this, "attend_corps_infos"), this.attend_corps_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.AttendCorpsInfo> getAttend_corps_infosAsData()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*      */     
/*  426 */     CrossBattleOwn _o_ = this;
/*  427 */     Map<Long, xbean.AttendCorpsInfo> attend_corps_infos = new HashMap();
/*  428 */     for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : _o_.attend_corps_infos.entrySet())
/*  429 */       attend_corps_infos.put(_e_.getKey(), new AttendCorpsInfo.Data((xbean.AttendCorpsInfo)_e_.getValue()));
/*  430 */     return attend_corps_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getVote_stage_direct_promotion_corps_list()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     return Logs.logList(new LogKey(this, "vote_stage_direct_promotion_corps_list"), this.vote_stage_direct_promotion_corps_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getVote_stage_direct_promotion_corps_listAsData()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*      */     
/*  446 */     CrossBattleOwn _o_ = this;
/*  447 */     List<Long> vote_stage_direct_promotion_corps_list = new ArrayList();
/*  448 */     vote_stage_direct_promotion_corps_list.addAll(_o_.vote_stage_direct_promotion_corps_list);
/*  449 */     return vote_stage_direct_promotion_corps_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getRound_robin_point_rank_list()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     return Logs.logList(new LogKey(this, "round_robin_point_rank_list"), this.round_robin_point_rank_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRound_robin_point_rank_listAsData()
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*      */     
/*  465 */     CrossBattleOwn _o_ = this;
/*  466 */     List<Long> round_robin_point_rank_list = new ArrayList();
/*  467 */     round_robin_point_rank_list.addAll(_o_.round_robin_point_rank_list);
/*  468 */     return round_robin_point_rank_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRound_robin_round_index()
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*  476 */     return this.round_robin_round_index;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.RoundRobinRoundInfo> getRound_robin_round_infos()
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     return Logs.logList(new LogKey(this, "round_robin_round_infos"), this.round_robin_round_infos);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.RoundRobinRoundInfo> getRound_robin_round_infosAsData()
/*      */   {
/*  490 */     _xdb_verify_unsafe_();
/*      */     
/*  492 */     CrossBattleOwn _o_ = this;
/*  493 */     List<xbean.RoundRobinRoundInfo> round_robin_round_infos = new ArrayList();
/*  494 */     for (xbean.RoundRobinRoundInfo _v_ : _o_.round_robin_round_infos)
/*  495 */       round_robin_round_infos.add(new RoundRobinRoundInfo.Data(_v_));
/*  496 */     return round_robin_round_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getRound_robin_stage_promotion_corps_list()
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     return Logs.logList(new LogKey(this, "round_robin_stage_promotion_corps_list"), this.round_robin_stage_promotion_corps_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRound_robin_stage_promotion_corps_listAsData()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*      */     
/*  512 */     CrossBattleOwn _o_ = this;
/*  513 */     List<Long> round_robin_stage_promotion_corps_list = new ArrayList();
/*  514 */     round_robin_stage_promotion_corps_list.addAll(_o_.round_robin_stage_promotion_corps_list);
/*  515 */     return round_robin_stage_promotion_corps_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getReport_result_success()
/*      */   {
/*  522 */     _xdb_verify_unsafe_();
/*  523 */     return this.report_result_success;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStage(int _v_)
/*      */   {
/*  530 */     _xdb_verify_unsafe_();
/*  531 */     Logs.logIf(new LogKey(this, "stage")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  535 */         new xdb.logs.LogInt(this, CrossBattleOwn.this.stage)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  539 */             CrossBattleOwn.this.stage = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  543 */     });
/*  544 */     this.stage = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRound_robin_round_index(int _v_)
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     Logs.logIf(new LogKey(this, "round_robin_round_index")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  556 */         new xdb.logs.LogInt(this, CrossBattleOwn.this.round_robin_round_index)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  560 */             CrossBattleOwn.this.round_robin_round_index = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  564 */     });
/*  565 */     this.round_robin_round_index = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReport_result_success(boolean _v_)
/*      */   {
/*  572 */     _xdb_verify_unsafe_();
/*  573 */     Logs.logIf(new LogKey(this, "report_result_success")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  577 */         new xdb.logs.LogObject(this, Boolean.valueOf(CrossBattleOwn.this.report_result_success))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  581 */             CrossBattleOwn.this.report_result_success = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  585 */     });
/*  586 */     this.report_result_success = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  592 */     _xdb_verify_unsafe_();
/*  593 */     CrossBattleOwn _o_ = null;
/*  594 */     if ((_o1_ instanceof CrossBattleOwn)) { _o_ = (CrossBattleOwn)_o1_;
/*  595 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  596 */       return false;
/*  597 */     if (this.stage != _o_.stage) return false;
/*  598 */     if (!this.attend_corps_infos.equals(_o_.attend_corps_infos)) return false;
/*  599 */     if (!this.vote_stage_direct_promotion_corps_list.equals(_o_.vote_stage_direct_promotion_corps_list)) return false;
/*  600 */     if (!this.round_robin_point_rank_list.equals(_o_.round_robin_point_rank_list)) return false;
/*  601 */     if (this.round_robin_round_index != _o_.round_robin_round_index) return false;
/*  602 */     if (!this.round_robin_round_infos.equals(_o_.round_robin_round_infos)) return false;
/*  603 */     if (!this.round_robin_stage_promotion_corps_list.equals(_o_.round_robin_stage_promotion_corps_list)) return false;
/*  604 */     if (this.report_result_success != _o_.report_result_success) return false;
/*  605 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  611 */     _xdb_verify_unsafe_();
/*  612 */     int _h_ = 0;
/*  613 */     _h_ += this.stage;
/*  614 */     _h_ += this.attend_corps_infos.hashCode();
/*  615 */     _h_ += this.vote_stage_direct_promotion_corps_list.hashCode();
/*  616 */     _h_ += this.round_robin_point_rank_list.hashCode();
/*  617 */     _h_ += this.round_robin_round_index;
/*  618 */     _h_ += this.round_robin_round_infos.hashCode();
/*  619 */     _h_ += this.round_robin_stage_promotion_corps_list.hashCode();
/*  620 */     _h_ += (this.report_result_success ? 1231 : 1237);
/*  621 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  627 */     _xdb_verify_unsafe_();
/*  628 */     StringBuilder _sb_ = new StringBuilder();
/*  629 */     _sb_.append("(");
/*  630 */     _sb_.append(this.stage);
/*  631 */     _sb_.append(",");
/*  632 */     _sb_.append(this.attend_corps_infos);
/*  633 */     _sb_.append(",");
/*  634 */     _sb_.append(this.vote_stage_direct_promotion_corps_list);
/*  635 */     _sb_.append(",");
/*  636 */     _sb_.append(this.round_robin_point_rank_list);
/*  637 */     _sb_.append(",");
/*  638 */     _sb_.append(this.round_robin_round_index);
/*  639 */     _sb_.append(",");
/*  640 */     _sb_.append(this.round_robin_round_infos);
/*  641 */     _sb_.append(",");
/*  642 */     _sb_.append(this.round_robin_stage_promotion_corps_list);
/*  643 */     _sb_.append(",");
/*  644 */     _sb_.append(this.report_result_success);
/*  645 */     _sb_.append(")");
/*  646 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  652 */     ListenableBean lb = new ListenableBean();
/*  653 */     lb.add(new ListenableChanged().setVarName("stage"));
/*  654 */     lb.add(new xdb.logs.ListenableMap().setVarName("attend_corps_infos"));
/*  655 */     lb.add(new ListenableChanged().setVarName("vote_stage_direct_promotion_corps_list"));
/*  656 */     lb.add(new ListenableChanged().setVarName("round_robin_point_rank_list"));
/*  657 */     lb.add(new ListenableChanged().setVarName("round_robin_round_index"));
/*  658 */     lb.add(new ListenableChanged().setVarName("round_robin_round_infos"));
/*  659 */     lb.add(new ListenableChanged().setVarName("round_robin_stage_promotion_corps_list"));
/*  660 */     lb.add(new ListenableChanged().setVarName("report_result_success"));
/*  661 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CrossBattleOwn {
/*      */     private Const() {}
/*      */     
/*      */     CrossBattleOwn nThis() {
/*  668 */       return CrossBattleOwn.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  674 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossBattleOwn copy()
/*      */     {
/*  680 */       return CrossBattleOwn.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossBattleOwn toData()
/*      */     {
/*  686 */       return CrossBattleOwn.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CrossBattleOwn toBean()
/*      */     {
/*  691 */       return CrossBattleOwn.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossBattleOwn toDataIf()
/*      */     {
/*  697 */       return CrossBattleOwn.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CrossBattleOwn toBeanIf()
/*      */     {
/*  702 */       return CrossBattleOwn.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/*  709 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  710 */       return CrossBattleOwn.this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AttendCorpsInfo> getAttend_corps_infos()
/*      */     {
/*  717 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  718 */       return xdb.Consts.constMap(CrossBattleOwn.this.attend_corps_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AttendCorpsInfo> getAttend_corps_infosAsData()
/*      */     {
/*  725 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*      */       
/*  727 */       CrossBattleOwn _o_ = CrossBattleOwn.this;
/*  728 */       Map<Long, xbean.AttendCorpsInfo> attend_corps_infos = new HashMap();
/*  729 */       for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : _o_.attend_corps_infos.entrySet())
/*  730 */         attend_corps_infos.put(_e_.getKey(), new AttendCorpsInfo.Data((xbean.AttendCorpsInfo)_e_.getValue()));
/*  731 */       return attend_corps_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVote_stage_direct_promotion_corps_list()
/*      */     {
/*  738 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  739 */       return xdb.Consts.constList(CrossBattleOwn.this.vote_stage_direct_promotion_corps_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getVote_stage_direct_promotion_corps_listAsData()
/*      */     {
/*  745 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*      */       
/*  747 */       CrossBattleOwn _o_ = CrossBattleOwn.this;
/*  748 */       List<Long> vote_stage_direct_promotion_corps_list = new ArrayList();
/*  749 */       vote_stage_direct_promotion_corps_list.addAll(_o_.vote_stage_direct_promotion_corps_list);
/*  750 */       return vote_stage_direct_promotion_corps_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRound_robin_point_rank_list()
/*      */     {
/*  757 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  758 */       return xdb.Consts.constList(CrossBattleOwn.this.round_robin_point_rank_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRound_robin_point_rank_listAsData()
/*      */     {
/*  764 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*      */       
/*  766 */       CrossBattleOwn _o_ = CrossBattleOwn.this;
/*  767 */       List<Long> round_robin_point_rank_list = new ArrayList();
/*  768 */       round_robin_point_rank_list.addAll(_o_.round_robin_point_rank_list);
/*  769 */       return round_robin_point_rank_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound_robin_round_index()
/*      */     {
/*  776 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  777 */       return CrossBattleOwn.this.round_robin_round_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RoundRobinRoundInfo> getRound_robin_round_infos()
/*      */     {
/*  784 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  785 */       return xdb.Consts.constList(CrossBattleOwn.this.round_robin_round_infos);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.RoundRobinRoundInfo> getRound_robin_round_infosAsData()
/*      */     {
/*  791 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*      */       
/*  793 */       CrossBattleOwn _o_ = CrossBattleOwn.this;
/*  794 */       List<xbean.RoundRobinRoundInfo> round_robin_round_infos = new ArrayList();
/*  795 */       for (xbean.RoundRobinRoundInfo _v_ : _o_.round_robin_round_infos)
/*  796 */         round_robin_round_infos.add(new RoundRobinRoundInfo.Data(_v_));
/*  797 */       return round_robin_round_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRound_robin_stage_promotion_corps_list()
/*      */     {
/*  804 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  805 */       return xdb.Consts.constList(CrossBattleOwn.this.round_robin_stage_promotion_corps_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRound_robin_stage_promotion_corps_listAsData()
/*      */     {
/*  811 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*      */       
/*  813 */       CrossBattleOwn _o_ = CrossBattleOwn.this;
/*  814 */       List<Long> round_robin_stage_promotion_corps_list = new ArrayList();
/*  815 */       round_robin_stage_promotion_corps_list.addAll(_o_.round_robin_stage_promotion_corps_list);
/*  816 */       return round_robin_stage_promotion_corps_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getReport_result_success()
/*      */     {
/*  823 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  824 */       return CrossBattleOwn.this.report_result_success;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/*  831 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  832 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_round_index(int _v_)
/*      */     {
/*  839 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  840 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReport_result_success(boolean _v_)
/*      */     {
/*  847 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  848 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  854 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  855 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  861 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  862 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  868 */       return CrossBattleOwn.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  874 */       return CrossBattleOwn.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  880 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  881 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  887 */       return CrossBattleOwn.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  893 */       return CrossBattleOwn.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  899 */       CrossBattleOwn.this._xdb_verify_unsafe_();
/*  900 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  906 */       return CrossBattleOwn.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  912 */       return CrossBattleOwn.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  918 */       return CrossBattleOwn.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  924 */       return CrossBattleOwn.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  930 */       return CrossBattleOwn.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  936 */       return CrossBattleOwn.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  942 */       return CrossBattleOwn.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CrossBattleOwn
/*      */   {
/*      */     private int stage;
/*      */     
/*      */     private HashMap<Long, xbean.AttendCorpsInfo> attend_corps_infos;
/*      */     
/*      */     private ArrayList<Long> vote_stage_direct_promotion_corps_list;
/*      */     
/*      */     private ArrayList<Long> round_robin_point_rank_list;
/*      */     
/*      */     private int round_robin_round_index;
/*      */     
/*      */     private ArrayList<xbean.RoundRobinRoundInfo> round_robin_round_infos;
/*      */     
/*      */     private ArrayList<Long> round_robin_stage_promotion_corps_list;
/*      */     
/*      */     private boolean report_result_success;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  973 */       this.stage = -1;
/*  974 */       this.attend_corps_infos = new HashMap();
/*  975 */       this.vote_stage_direct_promotion_corps_list = new ArrayList();
/*  976 */       this.round_robin_point_rank_list = new ArrayList();
/*  977 */       this.round_robin_round_index = 0;
/*  978 */       this.round_robin_round_infos = new ArrayList();
/*  979 */       this.round_robin_stage_promotion_corps_list = new ArrayList();
/*  980 */       this.report_result_success = false;
/*      */     }
/*      */     
/*      */     Data(xbean.CrossBattleOwn _o1_)
/*      */     {
/*  985 */       if ((_o1_ instanceof CrossBattleOwn)) { assign((CrossBattleOwn)_o1_);
/*  986 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  987 */       } else if ((_o1_ instanceof CrossBattleOwn.Const)) assign(((CrossBattleOwn.Const)_o1_).nThis()); else {
/*  988 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CrossBattleOwn _o_) {
/*  993 */       this.stage = _o_.stage;
/*  994 */       this.attend_corps_infos = new HashMap();
/*  995 */       for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : _o_.attend_corps_infos.entrySet())
/*  996 */         this.attend_corps_infos.put(_e_.getKey(), new AttendCorpsInfo.Data((xbean.AttendCorpsInfo)_e_.getValue()));
/*  997 */       this.vote_stage_direct_promotion_corps_list = new ArrayList();
/*  998 */       this.vote_stage_direct_promotion_corps_list.addAll(_o_.vote_stage_direct_promotion_corps_list);
/*  999 */       this.round_robin_point_rank_list = new ArrayList();
/* 1000 */       this.round_robin_point_rank_list.addAll(_o_.round_robin_point_rank_list);
/* 1001 */       this.round_robin_round_index = _o_.round_robin_round_index;
/* 1002 */       this.round_robin_round_infos = new ArrayList();
/* 1003 */       for (xbean.RoundRobinRoundInfo _v_ : _o_.round_robin_round_infos)
/* 1004 */         this.round_robin_round_infos.add(new RoundRobinRoundInfo.Data(_v_));
/* 1005 */       this.round_robin_stage_promotion_corps_list = new ArrayList();
/* 1006 */       this.round_robin_stage_promotion_corps_list.addAll(_o_.round_robin_stage_promotion_corps_list);
/* 1007 */       this.report_result_success = _o_.report_result_success;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1012 */       this.stage = _o_.stage;
/* 1013 */       this.attend_corps_infos = new HashMap();
/* 1014 */       for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : _o_.attend_corps_infos.entrySet())
/* 1015 */         this.attend_corps_infos.put(_e_.getKey(), new AttendCorpsInfo.Data((xbean.AttendCorpsInfo)_e_.getValue()));
/* 1016 */       this.vote_stage_direct_promotion_corps_list = new ArrayList();
/* 1017 */       this.vote_stage_direct_promotion_corps_list.addAll(_o_.vote_stage_direct_promotion_corps_list);
/* 1018 */       this.round_robin_point_rank_list = new ArrayList();
/* 1019 */       this.round_robin_point_rank_list.addAll(_o_.round_robin_point_rank_list);
/* 1020 */       this.round_robin_round_index = _o_.round_robin_round_index;
/* 1021 */       this.round_robin_round_infos = new ArrayList();
/* 1022 */       for (xbean.RoundRobinRoundInfo _v_ : _o_.round_robin_round_infos)
/* 1023 */         this.round_robin_round_infos.add(new RoundRobinRoundInfo.Data(_v_));
/* 1024 */       this.round_robin_stage_promotion_corps_list = new ArrayList();
/* 1025 */       this.round_robin_stage_promotion_corps_list.addAll(_o_.round_robin_stage_promotion_corps_list);
/* 1026 */       this.report_result_success = _o_.report_result_success;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1032 */       _os_.marshal(this.stage);
/* 1033 */       _os_.compact_uint32(this.attend_corps_infos.size());
/* 1034 */       for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : this.attend_corps_infos.entrySet())
/*      */       {
/* 1036 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1037 */         ((xbean.AttendCorpsInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1039 */       _os_.compact_uint32(this.vote_stage_direct_promotion_corps_list.size());
/* 1040 */       for (Long _v_ : this.vote_stage_direct_promotion_corps_list)
/*      */       {
/* 1042 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1044 */       _os_.compact_uint32(this.round_robin_point_rank_list.size());
/* 1045 */       for (Long _v_ : this.round_robin_point_rank_list)
/*      */       {
/* 1047 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1049 */       _os_.marshal(this.round_robin_round_index);
/* 1050 */       _os_.compact_uint32(this.round_robin_round_infos.size());
/* 1051 */       for (xbean.RoundRobinRoundInfo _v_ : this.round_robin_round_infos)
/*      */       {
/* 1053 */         _v_.marshal(_os_);
/*      */       }
/* 1055 */       _os_.compact_uint32(this.round_robin_stage_promotion_corps_list.size());
/* 1056 */       for (Long _v_ : this.round_robin_stage_promotion_corps_list)
/*      */       {
/* 1058 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1060 */       _os_.marshal(this.report_result_success);
/* 1061 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1067 */       this.stage = _os_.unmarshal_int();
/*      */       
/* 1069 */       int size = _os_.uncompact_uint32();
/* 1070 */       if (size >= 12)
/*      */       {
/* 1072 */         this.attend_corps_infos = new HashMap(size * 2);
/*      */       }
/* 1074 */       for (; size > 0; size--)
/*      */       {
/* 1076 */         long _k_ = 0L;
/* 1077 */         _k_ = _os_.unmarshal_long();
/* 1078 */         xbean.AttendCorpsInfo _v_ = xbean.Pod.newAttendCorpsInfoData();
/* 1079 */         _v_.unmarshal(_os_);
/* 1080 */         this.attend_corps_infos.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1083 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1085 */         long _v_ = 0L;
/* 1086 */         _v_ = _os_.unmarshal_long();
/* 1087 */         this.vote_stage_direct_promotion_corps_list.add(Long.valueOf(_v_));
/*      */       }
/* 1089 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1091 */         long _v_ = 0L;
/* 1092 */         _v_ = _os_.unmarshal_long();
/* 1093 */         this.round_robin_point_rank_list.add(Long.valueOf(_v_));
/*      */       }
/* 1095 */       this.round_robin_round_index = _os_.unmarshal_int();
/* 1096 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1098 */         xbean.RoundRobinRoundInfo _v_ = xbean.Pod.newRoundRobinRoundInfoData();
/* 1099 */         _v_.unmarshal(_os_);
/* 1100 */         this.round_robin_round_infos.add(_v_);
/*      */       }
/* 1102 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1104 */         long _v_ = 0L;
/* 1105 */         _v_ = _os_.unmarshal_long();
/* 1106 */         this.round_robin_stage_promotion_corps_list.add(Long.valueOf(_v_));
/*      */       }
/* 1108 */       this.report_result_success = _os_.unmarshal_boolean();
/* 1109 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1115 */       int _size_ = 0;
/* 1116 */       _size_ += CodedOutputStream.computeInt32Size(1, this.stage);
/* 1117 */       for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : this.attend_corps_infos.entrySet())
/*      */       {
/* 1119 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 1120 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1122 */       for (Long _v_ : this.vote_stage_direct_promotion_corps_list)
/*      */       {
/* 1124 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */       }
/* 1126 */       for (Long _v_ : this.round_robin_point_rank_list)
/*      */       {
/* 1128 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/* 1130 */       _size_ += CodedOutputStream.computeInt32Size(5, this.round_robin_round_index);
/* 1131 */       for (xbean.RoundRobinRoundInfo _v_ : this.round_robin_round_infos)
/*      */       {
/* 1133 */         _size_ += CodedOutputStream.computeMessageSize(6, _v_);
/*      */       }
/* 1135 */       for (Long _v_ : this.round_robin_stage_promotion_corps_list)
/*      */       {
/* 1137 */         _size_ += CodedOutputStream.computeInt64Size(7, _v_.longValue());
/*      */       }
/* 1139 */       _size_ += CodedOutputStream.computeBoolSize(8, this.report_result_success);
/* 1140 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1148 */         _output_.writeInt32(1, this.stage);
/* 1149 */         for (Map.Entry<Long, xbean.AttendCorpsInfo> _e_ : this.attend_corps_infos.entrySet())
/*      */         {
/* 1151 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 1152 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1154 */         for (Long _v_ : this.vote_stage_direct_promotion_corps_list)
/*      */         {
/* 1156 */           _output_.writeInt64(3, _v_.longValue());
/*      */         }
/* 1158 */         for (Long _v_ : this.round_robin_point_rank_list)
/*      */         {
/* 1160 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/* 1162 */         _output_.writeInt32(5, this.round_robin_round_index);
/* 1163 */         for (xbean.RoundRobinRoundInfo _v_ : this.round_robin_round_infos)
/*      */         {
/* 1165 */           _output_.writeMessage(6, _v_);
/*      */         }
/* 1167 */         for (Long _v_ : this.round_robin_stage_promotion_corps_list)
/*      */         {
/* 1169 */           _output_.writeInt64(7, _v_.longValue());
/*      */         }
/* 1171 */         _output_.writeBool(8, this.report_result_success);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1175 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1177 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1185 */         boolean done = false;
/* 1186 */         while (!done)
/*      */         {
/* 1188 */           int tag = _input_.readTag();
/* 1189 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1193 */             done = true;
/* 1194 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1198 */             this.stage = _input_.readInt32();
/* 1199 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1203 */             long _k_ = 0L;
/* 1204 */             _k_ = _input_.readInt64();
/* 1205 */             int readTag = _input_.readTag();
/* 1206 */             if (18 != readTag)
/*      */             {
/* 1208 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1210 */             xbean.AttendCorpsInfo _v_ = xbean.Pod.newAttendCorpsInfoData();
/* 1211 */             _input_.readMessage(_v_);
/* 1212 */             this.attend_corps_infos.put(Long.valueOf(_k_), _v_);
/* 1213 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1217 */             long _v_ = 0L;
/* 1218 */             _v_ = _input_.readInt64();
/* 1219 */             this.vote_stage_direct_promotion_corps_list.add(Long.valueOf(_v_));
/* 1220 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1224 */             long _v_ = 0L;
/* 1225 */             _v_ = _input_.readInt64();
/* 1226 */             this.round_robin_point_rank_list.add(Long.valueOf(_v_));
/* 1227 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1231 */             this.round_robin_round_index = _input_.readInt32();
/* 1232 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1236 */             xbean.RoundRobinRoundInfo _v_ = xbean.Pod.newRoundRobinRoundInfoData();
/* 1237 */             _input_.readMessage(_v_);
/* 1238 */             this.round_robin_round_infos.add(_v_);
/* 1239 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1243 */             long _v_ = 0L;
/* 1244 */             _v_ = _input_.readInt64();
/* 1245 */             this.round_robin_stage_promotion_corps_list.add(Long.valueOf(_v_));
/* 1246 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1250 */             this.report_result_success = _input_.readBool();
/* 1251 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1255 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1257 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1266 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1270 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1272 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossBattleOwn copy()
/*      */     {
/* 1278 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossBattleOwn toData()
/*      */     {
/* 1284 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CrossBattleOwn toBean()
/*      */     {
/* 1289 */       return new CrossBattleOwn(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossBattleOwn toDataIf()
/*      */     {
/* 1295 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CrossBattleOwn toBeanIf()
/*      */     {
/* 1300 */       return new CrossBattleOwn(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1306 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1310 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1314 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1318 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1322 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1326 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1330 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/* 1337 */       return this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AttendCorpsInfo> getAttend_corps_infos()
/*      */     {
/* 1344 */       return this.attend_corps_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AttendCorpsInfo> getAttend_corps_infosAsData()
/*      */     {
/* 1351 */       return this.attend_corps_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVote_stage_direct_promotion_corps_list()
/*      */     {
/* 1358 */       return this.vote_stage_direct_promotion_corps_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVote_stage_direct_promotion_corps_listAsData()
/*      */     {
/* 1365 */       return this.vote_stage_direct_promotion_corps_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRound_robin_point_rank_list()
/*      */     {
/* 1372 */       return this.round_robin_point_rank_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRound_robin_point_rank_listAsData()
/*      */     {
/* 1379 */       return this.round_robin_point_rank_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound_robin_round_index()
/*      */     {
/* 1386 */       return this.round_robin_round_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RoundRobinRoundInfo> getRound_robin_round_infos()
/*      */     {
/* 1393 */       return this.round_robin_round_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RoundRobinRoundInfo> getRound_robin_round_infosAsData()
/*      */     {
/* 1400 */       return this.round_robin_round_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRound_robin_stage_promotion_corps_list()
/*      */     {
/* 1407 */       return this.round_robin_stage_promotion_corps_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRound_robin_stage_promotion_corps_listAsData()
/*      */     {
/* 1414 */       return this.round_robin_stage_promotion_corps_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getReport_result_success()
/*      */     {
/* 1421 */       return this.report_result_success;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/* 1428 */       this.stage = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_round_index(int _v_)
/*      */     {
/* 1435 */       this.round_robin_round_index = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReport_result_success(boolean _v_)
/*      */     {
/* 1442 */       this.report_result_success = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1448 */       if (!(_o1_ instanceof Data)) return false;
/* 1449 */       Data _o_ = (Data)_o1_;
/* 1450 */       if (this.stage != _o_.stage) return false;
/* 1451 */       if (!this.attend_corps_infos.equals(_o_.attend_corps_infos)) return false;
/* 1452 */       if (!this.vote_stage_direct_promotion_corps_list.equals(_o_.vote_stage_direct_promotion_corps_list)) return false;
/* 1453 */       if (!this.round_robin_point_rank_list.equals(_o_.round_robin_point_rank_list)) return false;
/* 1454 */       if (this.round_robin_round_index != _o_.round_robin_round_index) return false;
/* 1455 */       if (!this.round_robin_round_infos.equals(_o_.round_robin_round_infos)) return false;
/* 1456 */       if (!this.round_robin_stage_promotion_corps_list.equals(_o_.round_robin_stage_promotion_corps_list)) return false;
/* 1457 */       if (this.report_result_success != _o_.report_result_success) return false;
/* 1458 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1464 */       int _h_ = 0;
/* 1465 */       _h_ += this.stage;
/* 1466 */       _h_ += this.attend_corps_infos.hashCode();
/* 1467 */       _h_ += this.vote_stage_direct_promotion_corps_list.hashCode();
/* 1468 */       _h_ += this.round_robin_point_rank_list.hashCode();
/* 1469 */       _h_ += this.round_robin_round_index;
/* 1470 */       _h_ += this.round_robin_round_infos.hashCode();
/* 1471 */       _h_ += this.round_robin_stage_promotion_corps_list.hashCode();
/* 1472 */       _h_ += (this.report_result_success ? 1231 : 1237);
/* 1473 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1479 */       StringBuilder _sb_ = new StringBuilder();
/* 1480 */       _sb_.append("(");
/* 1481 */       _sb_.append(this.stage);
/* 1482 */       _sb_.append(",");
/* 1483 */       _sb_.append(this.attend_corps_infos);
/* 1484 */       _sb_.append(",");
/* 1485 */       _sb_.append(this.vote_stage_direct_promotion_corps_list);
/* 1486 */       _sb_.append(",");
/* 1487 */       _sb_.append(this.round_robin_point_rank_list);
/* 1488 */       _sb_.append(",");
/* 1489 */       _sb_.append(this.round_robin_round_index);
/* 1490 */       _sb_.append(",");
/* 1491 */       _sb_.append(this.round_robin_round_infos);
/* 1492 */       _sb_.append(",");
/* 1493 */       _sb_.append(this.round_robin_stage_promotion_corps_list);
/* 1494 */       _sb_.append(",");
/* 1495 */       _sb_.append(this.report_result_success);
/* 1496 */       _sb_.append(")");
/* 1497 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossBattleOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */