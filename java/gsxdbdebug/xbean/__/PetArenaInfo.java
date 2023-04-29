/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xbean.Pod;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class PetArenaInfo extends XBean implements xbean.PetArenaInfo
/*      */ {
/*      */   private int today_point;
/*      */   private int challenge_count;
/*      */   private int buy_count;
/*      */   private long refresh_time;
/*      */   private ArrayList<xbean.PetArenaRankInfo> opponent_ranks;
/*      */   private int max_rank;
/*      */   private int win_num;
/*      */   private int lose_num;
/*      */   private int defend_win_num;
/*      */   private int defend_lose_num;
/*      */   private LinkedList<xbean.PetArenaFightRecordInfo> records;
/*      */   private long init_time;
/*      */   private xbean.PetArenaFightAward award;
/*      */   private int opponent_serial;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   44 */     this.today_point = 0;
/*   45 */     this.challenge_count = 0;
/*   46 */     this.buy_count = 0;
/*   47 */     this.refresh_time = 0L;
/*   48 */     this.opponent_ranks.clear();
/*   49 */     this.max_rank = 0;
/*   50 */     this.win_num = 0;
/*   51 */     this.lose_num = 0;
/*   52 */     this.defend_win_num = 0;
/*   53 */     this.defend_lose_num = 0;
/*   54 */     this.records.clear();
/*   55 */     this.init_time = 0L;
/*   56 */     this.award._reset_unsafe_();
/*   57 */     this.opponent_serial = 0;
/*      */   }
/*      */   
/*      */   PetArenaInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     this.today_point = 0;
/*   64 */     this.challenge_count = 0;
/*   65 */     this.buy_count = 0;
/*   66 */     this.refresh_time = 0L;
/*   67 */     this.opponent_ranks = new ArrayList();
/*   68 */     this.max_rank = 0;
/*   69 */     this.win_num = 0;
/*   70 */     this.lose_num = 0;
/*   71 */     this.defend_win_num = 0;
/*   72 */     this.defend_lose_num = 0;
/*   73 */     this.records = new LinkedList();
/*   74 */     this.init_time = 0L;
/*   75 */     this.award = new PetArenaFightAward(0, this, "award");
/*      */   }
/*      */   
/*      */   public PetArenaInfo()
/*      */   {
/*   80 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public PetArenaInfo(PetArenaInfo _o_)
/*      */   {
/*   85 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   PetArenaInfo(xbean.PetArenaInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   90 */     super(_xp_, _vn_);
/*   91 */     if ((_o1_ instanceof PetArenaInfo)) { assign((PetArenaInfo)_o1_);
/*   92 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   93 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   94 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(PetArenaInfo _o_) {
/*   99 */     _o_._xdb_verify_unsafe_();
/*  100 */     this.today_point = _o_.today_point;
/*  101 */     this.challenge_count = _o_.challenge_count;
/*  102 */     this.buy_count = _o_.buy_count;
/*  103 */     this.refresh_time = _o_.refresh_time;
/*  104 */     this.opponent_ranks = new ArrayList();
/*  105 */     for (xbean.PetArenaRankInfo _v_ : _o_.opponent_ranks)
/*  106 */       this.opponent_ranks.add(new PetArenaRankInfo(_v_, this, "opponent_ranks"));
/*  107 */     this.max_rank = _o_.max_rank;
/*  108 */     this.win_num = _o_.win_num;
/*  109 */     this.lose_num = _o_.lose_num;
/*  110 */     this.defend_win_num = _o_.defend_win_num;
/*  111 */     this.defend_lose_num = _o_.defend_lose_num;
/*  112 */     this.records = new LinkedList();
/*  113 */     for (xbean.PetArenaFightRecordInfo _v_ : _o_.records)
/*  114 */       this.records.add(new PetArenaFightRecordInfo(_v_, this, "records"));
/*  115 */     this.init_time = _o_.init_time;
/*  116 */     this.award = new PetArenaFightAward(_o_.award, this, "award");
/*  117 */     this.opponent_serial = _o_.opponent_serial;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  122 */     this.today_point = _o_.today_point;
/*  123 */     this.challenge_count = _o_.challenge_count;
/*  124 */     this.buy_count = _o_.buy_count;
/*  125 */     this.refresh_time = _o_.refresh_time;
/*  126 */     this.opponent_ranks = new ArrayList();
/*  127 */     for (xbean.PetArenaRankInfo _v_ : _o_.opponent_ranks)
/*  128 */       this.opponent_ranks.add(new PetArenaRankInfo(_v_, this, "opponent_ranks"));
/*  129 */     this.max_rank = _o_.max_rank;
/*  130 */     this.win_num = _o_.win_num;
/*  131 */     this.lose_num = _o_.lose_num;
/*  132 */     this.defend_win_num = _o_.defend_win_num;
/*  133 */     this.defend_lose_num = _o_.defend_lose_num;
/*  134 */     this.records = new LinkedList();
/*  135 */     for (xbean.PetArenaFightRecordInfo _v_ : _o_.records)
/*  136 */       this.records.add(new PetArenaFightRecordInfo(_v_, this, "records"));
/*  137 */     this.init_time = _o_.init_time;
/*  138 */     this.award = new PetArenaFightAward(_o_.award, this, "award");
/*  139 */     this.opponent_serial = _o_.opponent_serial;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  145 */     _xdb_verify_unsafe_();
/*  146 */     _os_.marshal(this.today_point);
/*  147 */     _os_.marshal(this.challenge_count);
/*  148 */     _os_.marshal(this.buy_count);
/*  149 */     _os_.marshal(this.refresh_time);
/*  150 */     _os_.compact_uint32(this.opponent_ranks.size());
/*  151 */     for (xbean.PetArenaRankInfo _v_ : this.opponent_ranks)
/*      */     {
/*  153 */       _v_.marshal(_os_);
/*      */     }
/*  155 */     _os_.marshal(this.max_rank);
/*  156 */     _os_.marshal(this.win_num);
/*  157 */     _os_.marshal(this.lose_num);
/*  158 */     _os_.marshal(this.defend_win_num);
/*  159 */     _os_.marshal(this.defend_lose_num);
/*  160 */     _os_.compact_uint32(this.records.size());
/*  161 */     for (xbean.PetArenaFightRecordInfo _v_ : this.records)
/*      */     {
/*  163 */       _v_.marshal(_os_);
/*      */     }
/*  165 */     _os_.marshal(this.init_time);
/*  166 */     this.award.marshal(_os_);
/*  167 */     _os_.marshal(this.opponent_serial);
/*  168 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  174 */     _xdb_verify_unsafe_();
/*  175 */     this.today_point = _os_.unmarshal_int();
/*  176 */     this.challenge_count = _os_.unmarshal_int();
/*  177 */     this.buy_count = _os_.unmarshal_int();
/*  178 */     this.refresh_time = _os_.unmarshal_long();
/*  179 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  181 */       xbean.PetArenaRankInfo _v_ = new PetArenaRankInfo(0, this, "opponent_ranks");
/*  182 */       _v_.unmarshal(_os_);
/*  183 */       this.opponent_ranks.add(_v_);
/*      */     }
/*  185 */     this.max_rank = _os_.unmarshal_int();
/*  186 */     this.win_num = _os_.unmarshal_int();
/*  187 */     this.lose_num = _os_.unmarshal_int();
/*  188 */     this.defend_win_num = _os_.unmarshal_int();
/*  189 */     this.defend_lose_num = _os_.unmarshal_int();
/*  190 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  192 */       xbean.PetArenaFightRecordInfo _v_ = new PetArenaFightRecordInfo(0, this, "records");
/*  193 */       _v_.unmarshal(_os_);
/*  194 */       this.records.add(_v_);
/*      */     }
/*  196 */     this.init_time = _os_.unmarshal_long();
/*  197 */     this.award.unmarshal(_os_);
/*  198 */     this.opponent_serial = _os_.unmarshal_int();
/*  199 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  205 */     _xdb_verify_unsafe_();
/*  206 */     int _size_ = 0;
/*  207 */     _size_ += CodedOutputStream.computeInt32Size(2, this.today_point);
/*  208 */     _size_ += CodedOutputStream.computeInt32Size(3, this.challenge_count);
/*  209 */     _size_ += CodedOutputStream.computeInt32Size(4, this.buy_count);
/*  210 */     _size_ += CodedOutputStream.computeInt64Size(5, this.refresh_time);
/*  211 */     for (xbean.PetArenaRankInfo _v_ : this.opponent_ranks)
/*      */     {
/*  213 */       _size_ += CodedOutputStream.computeMessageSize(6, _v_);
/*      */     }
/*  215 */     _size_ += CodedOutputStream.computeInt32Size(7, this.max_rank);
/*  216 */     _size_ += CodedOutputStream.computeInt32Size(8, this.win_num);
/*  217 */     _size_ += CodedOutputStream.computeInt32Size(9, this.lose_num);
/*  218 */     _size_ += CodedOutputStream.computeInt32Size(10, this.defend_win_num);
/*  219 */     _size_ += CodedOutputStream.computeInt32Size(11, this.defend_lose_num);
/*  220 */     for (xbean.PetArenaFightRecordInfo _v_ : this.records)
/*      */     {
/*  222 */       _size_ += CodedOutputStream.computeMessageSize(12, _v_);
/*      */     }
/*  224 */     _size_ += CodedOutputStream.computeInt64Size(13, this.init_time);
/*  225 */     _size_ += CodedOutputStream.computeMessageSize(14, this.award);
/*  226 */     _size_ += CodedOutputStream.computeInt32Size(15, this.opponent_serial);
/*  227 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  236 */       _output_.writeInt32(2, this.today_point);
/*  237 */       _output_.writeInt32(3, this.challenge_count);
/*  238 */       _output_.writeInt32(4, this.buy_count);
/*  239 */       _output_.writeInt64(5, this.refresh_time);
/*  240 */       for (xbean.PetArenaRankInfo _v_ : this.opponent_ranks)
/*      */       {
/*  242 */         _output_.writeMessage(6, _v_);
/*      */       }
/*  244 */       _output_.writeInt32(7, this.max_rank);
/*  245 */       _output_.writeInt32(8, this.win_num);
/*  246 */       _output_.writeInt32(9, this.lose_num);
/*  247 */       _output_.writeInt32(10, this.defend_win_num);
/*  248 */       _output_.writeInt32(11, this.defend_lose_num);
/*  249 */       for (xbean.PetArenaFightRecordInfo _v_ : this.records)
/*      */       {
/*  251 */         _output_.writeMessage(12, _v_);
/*      */       }
/*  253 */       _output_.writeInt64(13, this.init_time);
/*  254 */       _output_.writeMessage(14, this.award);
/*  255 */       _output_.writeInt32(15, this.opponent_serial);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  259 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  261 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  270 */       boolean done = false;
/*  271 */       while (!done)
/*      */       {
/*  273 */         int tag = _input_.readTag();
/*  274 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  278 */           done = true;
/*  279 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  283 */           this.today_point = _input_.readInt32();
/*  284 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  288 */           this.challenge_count = _input_.readInt32();
/*  289 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  293 */           this.buy_count = _input_.readInt32();
/*  294 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  298 */           this.refresh_time = _input_.readInt64();
/*  299 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  303 */           xbean.PetArenaRankInfo _v_ = new PetArenaRankInfo(0, this, "opponent_ranks");
/*  304 */           _input_.readMessage(_v_);
/*  305 */           this.opponent_ranks.add(_v_);
/*  306 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  310 */           this.max_rank = _input_.readInt32();
/*  311 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  315 */           this.win_num = _input_.readInt32();
/*  316 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  320 */           this.lose_num = _input_.readInt32();
/*  321 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  325 */           this.defend_win_num = _input_.readInt32();
/*  326 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  330 */           this.defend_lose_num = _input_.readInt32();
/*  331 */           break;
/*      */         
/*      */ 
/*      */         case 98: 
/*  335 */           xbean.PetArenaFightRecordInfo _v_ = new PetArenaFightRecordInfo(0, this, "records");
/*  336 */           _input_.readMessage(_v_);
/*  337 */           this.records.add(_v_);
/*  338 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  342 */           this.init_time = _input_.readInt64();
/*  343 */           break;
/*      */         
/*      */ 
/*      */         case 114: 
/*  347 */           _input_.readMessage(this.award);
/*  348 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  352 */           this.opponent_serial = _input_.readInt32();
/*  353 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  357 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  359 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  368 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  372 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  374 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaInfo copy()
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     return new PetArenaInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaInfo toData()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PetArenaInfo toBean()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return new PetArenaInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaInfo toDataIf()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PetArenaInfo toBeanIf()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*  414 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getToday_point()
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     return this.today_point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChallenge_count()
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     return this.challenge_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBuy_count()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     return this.buy_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRefresh_time()
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*  446 */     return this.refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.PetArenaRankInfo> getOpponent_ranks()
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     return Logs.logList(new LogKey(this, "opponent_ranks"), this.opponent_ranks);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.PetArenaRankInfo> getOpponent_ranksAsData()
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*      */     
/*  462 */     PetArenaInfo _o_ = this;
/*  463 */     List<xbean.PetArenaRankInfo> opponent_ranks = new ArrayList();
/*  464 */     for (xbean.PetArenaRankInfo _v_ : _o_.opponent_ranks)
/*  465 */       opponent_ranks.add(new PetArenaRankInfo.Data(_v_));
/*  466 */     return opponent_ranks;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMax_rank()
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     return this.max_rank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_num()
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*  482 */     return this.win_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLose_num()
/*      */   {
/*  489 */     _xdb_verify_unsafe_();
/*  490 */     return this.lose_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDefend_win_num()
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     return this.defend_win_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDefend_lose_num()
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     return this.defend_lose_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.PetArenaFightRecordInfo> getRecords()
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     return Logs.logList(new LogKey(this, "records"), this.records);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.PetArenaFightRecordInfo> getRecordsAsData()
/*      */   {
/*  520 */     _xdb_verify_unsafe_();
/*      */     
/*  522 */     PetArenaInfo _o_ = this;
/*  523 */     List<xbean.PetArenaFightRecordInfo> records = new LinkedList();
/*  524 */     for (xbean.PetArenaFightRecordInfo _v_ : _o_.records)
/*  525 */       records.add(new PetArenaFightRecordInfo.Data(_v_));
/*  526 */     return records;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInit_time()
/*      */   {
/*  533 */     _xdb_verify_unsafe_();
/*  534 */     return this.init_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.PetArenaFightAward getAward()
/*      */   {
/*  541 */     _xdb_verify_unsafe_();
/*  542 */     return this.award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOpponent_serial()
/*      */   {
/*  549 */     _xdb_verify_unsafe_();
/*  550 */     return this.opponent_serial;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setToday_point(int _v_)
/*      */   {
/*  557 */     _xdb_verify_unsafe_();
/*  558 */     Logs.logIf(new LogKey(this, "today_point")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  562 */         new LogInt(this, PetArenaInfo.this.today_point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  566 */             PetArenaInfo.this.today_point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  570 */     });
/*  571 */     this.today_point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChallenge_count(int _v_)
/*      */   {
/*  578 */     _xdb_verify_unsafe_();
/*  579 */     Logs.logIf(new LogKey(this, "challenge_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  583 */         new LogInt(this, PetArenaInfo.this.challenge_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  587 */             PetArenaInfo.this.challenge_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  591 */     });
/*  592 */     this.challenge_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuy_count(int _v_)
/*      */   {
/*  599 */     _xdb_verify_unsafe_();
/*  600 */     Logs.logIf(new LogKey(this, "buy_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  604 */         new LogInt(this, PetArenaInfo.this.buy_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  608 */             PetArenaInfo.this.buy_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  612 */     });
/*  613 */     this.buy_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRefresh_time(long _v_)
/*      */   {
/*  620 */     _xdb_verify_unsafe_();
/*  621 */     Logs.logIf(new LogKey(this, "refresh_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  625 */         new LogLong(this, PetArenaInfo.this.refresh_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  629 */             PetArenaInfo.this.refresh_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  633 */     });
/*  634 */     this.refresh_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMax_rank(int _v_)
/*      */   {
/*  641 */     _xdb_verify_unsafe_();
/*  642 */     Logs.logIf(new LogKey(this, "max_rank")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  646 */         new LogInt(this, PetArenaInfo.this.max_rank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  650 */             PetArenaInfo.this.max_rank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  654 */     });
/*  655 */     this.max_rank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_num(int _v_)
/*      */   {
/*  662 */     _xdb_verify_unsafe_();
/*  663 */     Logs.logIf(new LogKey(this, "win_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  667 */         new LogInt(this, PetArenaInfo.this.win_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  671 */             PetArenaInfo.this.win_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  675 */     });
/*  676 */     this.win_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLose_num(int _v_)
/*      */   {
/*  683 */     _xdb_verify_unsafe_();
/*  684 */     Logs.logIf(new LogKey(this, "lose_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  688 */         new LogInt(this, PetArenaInfo.this.lose_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  692 */             PetArenaInfo.this.lose_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  696 */     });
/*  697 */     this.lose_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDefend_win_num(int _v_)
/*      */   {
/*  704 */     _xdb_verify_unsafe_();
/*  705 */     Logs.logIf(new LogKey(this, "defend_win_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  709 */         new LogInt(this, PetArenaInfo.this.defend_win_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  713 */             PetArenaInfo.this.defend_win_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  717 */     });
/*  718 */     this.defend_win_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDefend_lose_num(int _v_)
/*      */   {
/*  725 */     _xdb_verify_unsafe_();
/*  726 */     Logs.logIf(new LogKey(this, "defend_lose_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  730 */         new LogInt(this, PetArenaInfo.this.defend_lose_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  734 */             PetArenaInfo.this.defend_lose_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  738 */     });
/*  739 */     this.defend_lose_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInit_time(long _v_)
/*      */   {
/*  746 */     _xdb_verify_unsafe_();
/*  747 */     Logs.logIf(new LogKey(this, "init_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  751 */         new LogLong(this, PetArenaInfo.this.init_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  755 */             PetArenaInfo.this.init_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  759 */     });
/*  760 */     this.init_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOpponent_serial(int _v_)
/*      */   {
/*  767 */     _xdb_verify_unsafe_();
/*  768 */     Logs.logIf(new LogKey(this, "opponent_serial")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  772 */         new LogInt(this, PetArenaInfo.this.opponent_serial)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  776 */             PetArenaInfo.this.opponent_serial = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  780 */     });
/*  781 */     this.opponent_serial = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  787 */     _xdb_verify_unsafe_();
/*  788 */     PetArenaInfo _o_ = null;
/*  789 */     if ((_o1_ instanceof PetArenaInfo)) { _o_ = (PetArenaInfo)_o1_;
/*  790 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  791 */       return false;
/*  792 */     if (this.today_point != _o_.today_point) return false;
/*  793 */     if (this.challenge_count != _o_.challenge_count) return false;
/*  794 */     if (this.buy_count != _o_.buy_count) return false;
/*  795 */     if (this.refresh_time != _o_.refresh_time) return false;
/*  796 */     if (!this.opponent_ranks.equals(_o_.opponent_ranks)) return false;
/*  797 */     if (this.max_rank != _o_.max_rank) return false;
/*  798 */     if (this.win_num != _o_.win_num) return false;
/*  799 */     if (this.lose_num != _o_.lose_num) return false;
/*  800 */     if (this.defend_win_num != _o_.defend_win_num) return false;
/*  801 */     if (this.defend_lose_num != _o_.defend_lose_num) return false;
/*  802 */     if (!this.records.equals(_o_.records)) return false;
/*  803 */     if (this.init_time != _o_.init_time) return false;
/*  804 */     if (!this.award.equals(_o_.award)) return false;
/*  805 */     if (this.opponent_serial != _o_.opponent_serial) return false;
/*  806 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  812 */     _xdb_verify_unsafe_();
/*  813 */     int _h_ = 0;
/*  814 */     _h_ += this.today_point;
/*  815 */     _h_ += this.challenge_count;
/*  816 */     _h_ += this.buy_count;
/*  817 */     _h_ = (int)(_h_ + this.refresh_time);
/*  818 */     _h_ += this.opponent_ranks.hashCode();
/*  819 */     _h_ += this.max_rank;
/*  820 */     _h_ += this.win_num;
/*  821 */     _h_ += this.lose_num;
/*  822 */     _h_ += this.defend_win_num;
/*  823 */     _h_ += this.defend_lose_num;
/*  824 */     _h_ += this.records.hashCode();
/*  825 */     _h_ = (int)(_h_ + this.init_time);
/*  826 */     _h_ += this.award.hashCode();
/*  827 */     _h_ += this.opponent_serial;
/*  828 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  834 */     _xdb_verify_unsafe_();
/*  835 */     StringBuilder _sb_ = new StringBuilder();
/*  836 */     _sb_.append("(");
/*  837 */     _sb_.append(this.today_point);
/*  838 */     _sb_.append(",");
/*  839 */     _sb_.append(this.challenge_count);
/*  840 */     _sb_.append(",");
/*  841 */     _sb_.append(this.buy_count);
/*  842 */     _sb_.append(",");
/*  843 */     _sb_.append(this.refresh_time);
/*  844 */     _sb_.append(",");
/*  845 */     _sb_.append(this.opponent_ranks);
/*  846 */     _sb_.append(",");
/*  847 */     _sb_.append(this.max_rank);
/*  848 */     _sb_.append(",");
/*  849 */     _sb_.append(this.win_num);
/*  850 */     _sb_.append(",");
/*  851 */     _sb_.append(this.lose_num);
/*  852 */     _sb_.append(",");
/*  853 */     _sb_.append(this.defend_win_num);
/*  854 */     _sb_.append(",");
/*  855 */     _sb_.append(this.defend_lose_num);
/*  856 */     _sb_.append(",");
/*  857 */     _sb_.append(this.records);
/*  858 */     _sb_.append(",");
/*  859 */     _sb_.append(this.init_time);
/*  860 */     _sb_.append(",");
/*  861 */     _sb_.append(this.award);
/*  862 */     _sb_.append(",");
/*  863 */     _sb_.append(this.opponent_serial);
/*  864 */     _sb_.append(")");
/*  865 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/*  871 */     ListenableBean lb = new ListenableBean();
/*  872 */     lb.add(new ListenableChanged().setVarName("today_point"));
/*  873 */     lb.add(new ListenableChanged().setVarName("challenge_count"));
/*  874 */     lb.add(new ListenableChanged().setVarName("buy_count"));
/*  875 */     lb.add(new ListenableChanged().setVarName("refresh_time"));
/*  876 */     lb.add(new ListenableChanged().setVarName("opponent_ranks"));
/*  877 */     lb.add(new ListenableChanged().setVarName("max_rank"));
/*  878 */     lb.add(new ListenableChanged().setVarName("win_num"));
/*  879 */     lb.add(new ListenableChanged().setVarName("lose_num"));
/*  880 */     lb.add(new ListenableChanged().setVarName("defend_win_num"));
/*  881 */     lb.add(new ListenableChanged().setVarName("defend_lose_num"));
/*  882 */     lb.add(new ListenableChanged().setVarName("records"));
/*  883 */     lb.add(new ListenableChanged().setVarName("init_time"));
/*  884 */     lb.add(new ListenableChanged().setVarName("award"));
/*  885 */     lb.add(new ListenableChanged().setVarName("opponent_serial"));
/*  886 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.PetArenaInfo {
/*      */     private Const() {}
/*      */     
/*      */     PetArenaInfo nThis() {
/*  893 */       return PetArenaInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaInfo copy()
/*      */     {
/*  905 */       return PetArenaInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaInfo toData()
/*      */     {
/*  911 */       return PetArenaInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.PetArenaInfo toBean()
/*      */     {
/*  916 */       return PetArenaInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaInfo toDataIf()
/*      */     {
/*  922 */       return PetArenaInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.PetArenaInfo toBeanIf()
/*      */     {
/*  927 */       return PetArenaInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToday_point()
/*      */     {
/*  934 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*  935 */       return PetArenaInfo.this.today_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChallenge_count()
/*      */     {
/*  942 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*  943 */       return PetArenaInfo.this.challenge_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuy_count()
/*      */     {
/*  950 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*  951 */       return PetArenaInfo.this.buy_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRefresh_time()
/*      */     {
/*  958 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*  959 */       return PetArenaInfo.this.refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaRankInfo> getOpponent_ranks()
/*      */     {
/*  966 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*  967 */       return Consts.constList(PetArenaInfo.this.opponent_ranks);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.PetArenaRankInfo> getOpponent_ranksAsData()
/*      */     {
/*  973 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*      */       
/*  975 */       PetArenaInfo _o_ = PetArenaInfo.this;
/*  976 */       List<xbean.PetArenaRankInfo> opponent_ranks = new ArrayList();
/*  977 */       for (xbean.PetArenaRankInfo _v_ : _o_.opponent_ranks)
/*  978 */         opponent_ranks.add(new PetArenaRankInfo.Data(_v_));
/*  979 */       return opponent_ranks;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMax_rank()
/*      */     {
/*  986 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*  987 */       return PetArenaInfo.this.max_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_num()
/*      */     {
/*  994 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*  995 */       return PetArenaInfo.this.win_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_num()
/*      */     {
/* 1002 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1003 */       return PetArenaInfo.this.lose_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefend_win_num()
/*      */     {
/* 1010 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1011 */       return PetArenaInfo.this.defend_win_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefend_lose_num()
/*      */     {
/* 1018 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1019 */       return PetArenaInfo.this.defend_lose_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightRecordInfo> getRecords()
/*      */     {
/* 1026 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1027 */       return Consts.constList(PetArenaInfo.this.records);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.PetArenaFightRecordInfo> getRecordsAsData()
/*      */     {
/* 1033 */       PetArenaInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1035 */       PetArenaInfo _o_ = PetArenaInfo.this;
/* 1036 */       List<xbean.PetArenaFightRecordInfo> records = new LinkedList();
/* 1037 */       for (xbean.PetArenaFightRecordInfo _v_ : _o_.records)
/* 1038 */         records.add(new PetArenaFightRecordInfo.Data(_v_));
/* 1039 */       return records;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInit_time()
/*      */     {
/* 1046 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1047 */       return PetArenaInfo.this.init_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.PetArenaFightAward getAward()
/*      */     {
/* 1054 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1055 */       return (xbean.PetArenaFightAward)Consts.toConst(PetArenaInfo.this.award);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOpponent_serial()
/*      */     {
/* 1062 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1063 */       return PetArenaInfo.this.opponent_serial;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToday_point(int _v_)
/*      */     {
/* 1070 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1071 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChallenge_count(int _v_)
/*      */     {
/* 1078 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1079 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuy_count(int _v_)
/*      */     {
/* 1086 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1087 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefresh_time(long _v_)
/*      */     {
/* 1094 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1095 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_rank(int _v_)
/*      */     {
/* 1102 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1103 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_num(int _v_)
/*      */     {
/* 1110 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1111 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_num(int _v_)
/*      */     {
/* 1118 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1119 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefend_win_num(int _v_)
/*      */     {
/* 1126 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1127 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefend_lose_num(int _v_)
/*      */     {
/* 1134 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1135 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInit_time(long _v_)
/*      */     {
/* 1142 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1143 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpponent_serial(int _v_)
/*      */     {
/* 1150 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1151 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1157 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1158 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1164 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1165 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1171 */       return PetArenaInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1177 */       return PetArenaInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1183 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1184 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1190 */       return PetArenaInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1196 */       return PetArenaInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1202 */       PetArenaInfo.this._xdb_verify_unsafe_();
/* 1203 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1209 */       return PetArenaInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1215 */       return PetArenaInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1221 */       return PetArenaInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1227 */       return PetArenaInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1233 */       return PetArenaInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1239 */       return PetArenaInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1245 */       return PetArenaInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.PetArenaInfo
/*      */   {
/*      */     private int today_point;
/*      */     
/*      */     private int challenge_count;
/*      */     
/*      */     private int buy_count;
/*      */     
/*      */     private long refresh_time;
/*      */     
/*      */     private ArrayList<xbean.PetArenaRankInfo> opponent_ranks;
/*      */     
/*      */     private int max_rank;
/*      */     
/*      */     private int win_num;
/*      */     
/*      */     private int lose_num;
/*      */     
/*      */     private int defend_win_num;
/*      */     
/*      */     private int defend_lose_num;
/*      */     
/*      */     private LinkedList<xbean.PetArenaFightRecordInfo> records;
/*      */     
/*      */     private long init_time;
/*      */     
/*      */     private xbean.PetArenaFightAward award;
/*      */     
/*      */     private int opponent_serial;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1283 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1288 */       this.today_point = 0;
/* 1289 */       this.challenge_count = 0;
/* 1290 */       this.buy_count = 0;
/* 1291 */       this.refresh_time = 0L;
/* 1292 */       this.opponent_ranks = new ArrayList();
/* 1293 */       this.max_rank = 0;
/* 1294 */       this.win_num = 0;
/* 1295 */       this.lose_num = 0;
/* 1296 */       this.defend_win_num = 0;
/* 1297 */       this.defend_lose_num = 0;
/* 1298 */       this.records = new LinkedList();
/* 1299 */       this.init_time = 0L;
/* 1300 */       this.award = new PetArenaFightAward.Data();
/*      */     }
/*      */     
/*      */     Data(xbean.PetArenaInfo _o1_)
/*      */     {
/* 1305 */       if ((_o1_ instanceof PetArenaInfo)) { assign((PetArenaInfo)_o1_);
/* 1306 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1307 */       } else if ((_o1_ instanceof PetArenaInfo.Const)) assign(((PetArenaInfo.Const)_o1_).nThis()); else {
/* 1308 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(PetArenaInfo _o_) {
/* 1313 */       this.today_point = _o_.today_point;
/* 1314 */       this.challenge_count = _o_.challenge_count;
/* 1315 */       this.buy_count = _o_.buy_count;
/* 1316 */       this.refresh_time = _o_.refresh_time;
/* 1317 */       this.opponent_ranks = new ArrayList();
/* 1318 */       for (xbean.PetArenaRankInfo _v_ : _o_.opponent_ranks)
/* 1319 */         this.opponent_ranks.add(new PetArenaRankInfo.Data(_v_));
/* 1320 */       this.max_rank = _o_.max_rank;
/* 1321 */       this.win_num = _o_.win_num;
/* 1322 */       this.lose_num = _o_.lose_num;
/* 1323 */       this.defend_win_num = _o_.defend_win_num;
/* 1324 */       this.defend_lose_num = _o_.defend_lose_num;
/* 1325 */       this.records = new LinkedList();
/* 1326 */       for (xbean.PetArenaFightRecordInfo _v_ : _o_.records)
/* 1327 */         this.records.add(new PetArenaFightRecordInfo.Data(_v_));
/* 1328 */       this.init_time = _o_.init_time;
/* 1329 */       this.award = new PetArenaFightAward.Data(_o_.award);
/* 1330 */       this.opponent_serial = _o_.opponent_serial;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1335 */       this.today_point = _o_.today_point;
/* 1336 */       this.challenge_count = _o_.challenge_count;
/* 1337 */       this.buy_count = _o_.buy_count;
/* 1338 */       this.refresh_time = _o_.refresh_time;
/* 1339 */       this.opponent_ranks = new ArrayList();
/* 1340 */       for (xbean.PetArenaRankInfo _v_ : _o_.opponent_ranks)
/* 1341 */         this.opponent_ranks.add(new PetArenaRankInfo.Data(_v_));
/* 1342 */       this.max_rank = _o_.max_rank;
/* 1343 */       this.win_num = _o_.win_num;
/* 1344 */       this.lose_num = _o_.lose_num;
/* 1345 */       this.defend_win_num = _o_.defend_win_num;
/* 1346 */       this.defend_lose_num = _o_.defend_lose_num;
/* 1347 */       this.records = new LinkedList();
/* 1348 */       for (xbean.PetArenaFightRecordInfo _v_ : _o_.records)
/* 1349 */         this.records.add(new PetArenaFightRecordInfo.Data(_v_));
/* 1350 */       this.init_time = _o_.init_time;
/* 1351 */       this.award = new PetArenaFightAward.Data(_o_.award);
/* 1352 */       this.opponent_serial = _o_.opponent_serial;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1358 */       _os_.marshal(this.today_point);
/* 1359 */       _os_.marshal(this.challenge_count);
/* 1360 */       _os_.marshal(this.buy_count);
/* 1361 */       _os_.marshal(this.refresh_time);
/* 1362 */       _os_.compact_uint32(this.opponent_ranks.size());
/* 1363 */       for (xbean.PetArenaRankInfo _v_ : this.opponent_ranks)
/*      */       {
/* 1365 */         _v_.marshal(_os_);
/*      */       }
/* 1367 */       _os_.marshal(this.max_rank);
/* 1368 */       _os_.marshal(this.win_num);
/* 1369 */       _os_.marshal(this.lose_num);
/* 1370 */       _os_.marshal(this.defend_win_num);
/* 1371 */       _os_.marshal(this.defend_lose_num);
/* 1372 */       _os_.compact_uint32(this.records.size());
/* 1373 */       for (xbean.PetArenaFightRecordInfo _v_ : this.records)
/*      */       {
/* 1375 */         _v_.marshal(_os_);
/*      */       }
/* 1377 */       _os_.marshal(this.init_time);
/* 1378 */       this.award.marshal(_os_);
/* 1379 */       _os_.marshal(this.opponent_serial);
/* 1380 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1386 */       this.today_point = _os_.unmarshal_int();
/* 1387 */       this.challenge_count = _os_.unmarshal_int();
/* 1388 */       this.buy_count = _os_.unmarshal_int();
/* 1389 */       this.refresh_time = _os_.unmarshal_long();
/* 1390 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1392 */         xbean.PetArenaRankInfo _v_ = Pod.newPetArenaRankInfoData();
/* 1393 */         _v_.unmarshal(_os_);
/* 1394 */         this.opponent_ranks.add(_v_);
/*      */       }
/* 1396 */       this.max_rank = _os_.unmarshal_int();
/* 1397 */       this.win_num = _os_.unmarshal_int();
/* 1398 */       this.lose_num = _os_.unmarshal_int();
/* 1399 */       this.defend_win_num = _os_.unmarshal_int();
/* 1400 */       this.defend_lose_num = _os_.unmarshal_int();
/* 1401 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1403 */         xbean.PetArenaFightRecordInfo _v_ = Pod.newPetArenaFightRecordInfoData();
/* 1404 */         _v_.unmarshal(_os_);
/* 1405 */         this.records.add(_v_);
/*      */       }
/* 1407 */       this.init_time = _os_.unmarshal_long();
/* 1408 */       this.award.unmarshal(_os_);
/* 1409 */       this.opponent_serial = _os_.unmarshal_int();
/* 1410 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1416 */       int _size_ = 0;
/* 1417 */       _size_ += CodedOutputStream.computeInt32Size(2, this.today_point);
/* 1418 */       _size_ += CodedOutputStream.computeInt32Size(3, this.challenge_count);
/* 1419 */       _size_ += CodedOutputStream.computeInt32Size(4, this.buy_count);
/* 1420 */       _size_ += CodedOutputStream.computeInt64Size(5, this.refresh_time);
/* 1421 */       for (xbean.PetArenaRankInfo _v_ : this.opponent_ranks)
/*      */       {
/* 1423 */         _size_ += CodedOutputStream.computeMessageSize(6, _v_);
/*      */       }
/* 1425 */       _size_ += CodedOutputStream.computeInt32Size(7, this.max_rank);
/* 1426 */       _size_ += CodedOutputStream.computeInt32Size(8, this.win_num);
/* 1427 */       _size_ += CodedOutputStream.computeInt32Size(9, this.lose_num);
/* 1428 */       _size_ += CodedOutputStream.computeInt32Size(10, this.defend_win_num);
/* 1429 */       _size_ += CodedOutputStream.computeInt32Size(11, this.defend_lose_num);
/* 1430 */       for (xbean.PetArenaFightRecordInfo _v_ : this.records)
/*      */       {
/* 1432 */         _size_ += CodedOutputStream.computeMessageSize(12, _v_);
/*      */       }
/* 1434 */       _size_ += CodedOutputStream.computeInt64Size(13, this.init_time);
/* 1435 */       _size_ += CodedOutputStream.computeMessageSize(14, this.award);
/* 1436 */       _size_ += CodedOutputStream.computeInt32Size(15, this.opponent_serial);
/* 1437 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1445 */         _output_.writeInt32(2, this.today_point);
/* 1446 */         _output_.writeInt32(3, this.challenge_count);
/* 1447 */         _output_.writeInt32(4, this.buy_count);
/* 1448 */         _output_.writeInt64(5, this.refresh_time);
/* 1449 */         for (xbean.PetArenaRankInfo _v_ : this.opponent_ranks)
/*      */         {
/* 1451 */           _output_.writeMessage(6, _v_);
/*      */         }
/* 1453 */         _output_.writeInt32(7, this.max_rank);
/* 1454 */         _output_.writeInt32(8, this.win_num);
/* 1455 */         _output_.writeInt32(9, this.lose_num);
/* 1456 */         _output_.writeInt32(10, this.defend_win_num);
/* 1457 */         _output_.writeInt32(11, this.defend_lose_num);
/* 1458 */         for (xbean.PetArenaFightRecordInfo _v_ : this.records)
/*      */         {
/* 1460 */           _output_.writeMessage(12, _v_);
/*      */         }
/* 1462 */         _output_.writeInt64(13, this.init_time);
/* 1463 */         _output_.writeMessage(14, this.award);
/* 1464 */         _output_.writeInt32(15, this.opponent_serial);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1468 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1470 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1478 */         boolean done = false;
/* 1479 */         while (!done)
/*      */         {
/* 1481 */           int tag = _input_.readTag();
/* 1482 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1486 */             done = true;
/* 1487 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1491 */             this.today_point = _input_.readInt32();
/* 1492 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1496 */             this.challenge_count = _input_.readInt32();
/* 1497 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1501 */             this.buy_count = _input_.readInt32();
/* 1502 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1506 */             this.refresh_time = _input_.readInt64();
/* 1507 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1511 */             xbean.PetArenaRankInfo _v_ = Pod.newPetArenaRankInfoData();
/* 1512 */             _input_.readMessage(_v_);
/* 1513 */             this.opponent_ranks.add(_v_);
/* 1514 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1518 */             this.max_rank = _input_.readInt32();
/* 1519 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1523 */             this.win_num = _input_.readInt32();
/* 1524 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1528 */             this.lose_num = _input_.readInt32();
/* 1529 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1533 */             this.defend_win_num = _input_.readInt32();
/* 1534 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1538 */             this.defend_lose_num = _input_.readInt32();
/* 1539 */             break;
/*      */           
/*      */ 
/*      */           case 98: 
/* 1543 */             xbean.PetArenaFightRecordInfo _v_ = Pod.newPetArenaFightRecordInfoData();
/* 1544 */             _input_.readMessage(_v_);
/* 1545 */             this.records.add(_v_);
/* 1546 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1550 */             this.init_time = _input_.readInt64();
/* 1551 */             break;
/*      */           
/*      */ 
/*      */           case 114: 
/* 1555 */             _input_.readMessage(this.award);
/* 1556 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 1560 */             this.opponent_serial = _input_.readInt32();
/* 1561 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1565 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1567 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1576 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1580 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1582 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaInfo copy()
/*      */     {
/* 1588 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaInfo toData()
/*      */     {
/* 1594 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.PetArenaInfo toBean()
/*      */     {
/* 1599 */       return new PetArenaInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaInfo toDataIf()
/*      */     {
/* 1605 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.PetArenaInfo toBeanIf()
/*      */     {
/* 1610 */       return new PetArenaInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1616 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1620 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1624 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1632 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1636 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1640 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToday_point()
/*      */     {
/* 1647 */       return this.today_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChallenge_count()
/*      */     {
/* 1654 */       return this.challenge_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuy_count()
/*      */     {
/* 1661 */       return this.buy_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRefresh_time()
/*      */     {
/* 1668 */       return this.refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaRankInfo> getOpponent_ranks()
/*      */     {
/* 1675 */       return this.opponent_ranks;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaRankInfo> getOpponent_ranksAsData()
/*      */     {
/* 1682 */       return this.opponent_ranks;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMax_rank()
/*      */     {
/* 1689 */       return this.max_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_num()
/*      */     {
/* 1696 */       return this.win_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_num()
/*      */     {
/* 1703 */       return this.lose_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefend_win_num()
/*      */     {
/* 1710 */       return this.defend_win_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefend_lose_num()
/*      */     {
/* 1717 */       return this.defend_lose_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightRecordInfo> getRecords()
/*      */     {
/* 1724 */       return this.records;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetArenaFightRecordInfo> getRecordsAsData()
/*      */     {
/* 1731 */       return this.records;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInit_time()
/*      */     {
/* 1738 */       return this.init_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.PetArenaFightAward getAward()
/*      */     {
/* 1745 */       return this.award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOpponent_serial()
/*      */     {
/* 1752 */       return this.opponent_serial;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToday_point(int _v_)
/*      */     {
/* 1759 */       this.today_point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChallenge_count(int _v_)
/*      */     {
/* 1766 */       this.challenge_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuy_count(int _v_)
/*      */     {
/* 1773 */       this.buy_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefresh_time(long _v_)
/*      */     {
/* 1780 */       this.refresh_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_rank(int _v_)
/*      */     {
/* 1787 */       this.max_rank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_num(int _v_)
/*      */     {
/* 1794 */       this.win_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_num(int _v_)
/*      */     {
/* 1801 */       this.lose_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefend_win_num(int _v_)
/*      */     {
/* 1808 */       this.defend_win_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefend_lose_num(int _v_)
/*      */     {
/* 1815 */       this.defend_lose_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInit_time(long _v_)
/*      */     {
/* 1822 */       this.init_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpponent_serial(int _v_)
/*      */     {
/* 1829 */       this.opponent_serial = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1835 */       if (!(_o1_ instanceof Data)) return false;
/* 1836 */       Data _o_ = (Data)_o1_;
/* 1837 */       if (this.today_point != _o_.today_point) return false;
/* 1838 */       if (this.challenge_count != _o_.challenge_count) return false;
/* 1839 */       if (this.buy_count != _o_.buy_count) return false;
/* 1840 */       if (this.refresh_time != _o_.refresh_time) return false;
/* 1841 */       if (!this.opponent_ranks.equals(_o_.opponent_ranks)) return false;
/* 1842 */       if (this.max_rank != _o_.max_rank) return false;
/* 1843 */       if (this.win_num != _o_.win_num) return false;
/* 1844 */       if (this.lose_num != _o_.lose_num) return false;
/* 1845 */       if (this.defend_win_num != _o_.defend_win_num) return false;
/* 1846 */       if (this.defend_lose_num != _o_.defend_lose_num) return false;
/* 1847 */       if (!this.records.equals(_o_.records)) return false;
/* 1848 */       if (this.init_time != _o_.init_time) return false;
/* 1849 */       if (!this.award.equals(_o_.award)) return false;
/* 1850 */       if (this.opponent_serial != _o_.opponent_serial) return false;
/* 1851 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1857 */       int _h_ = 0;
/* 1858 */       _h_ += this.today_point;
/* 1859 */       _h_ += this.challenge_count;
/* 1860 */       _h_ += this.buy_count;
/* 1861 */       _h_ = (int)(_h_ + this.refresh_time);
/* 1862 */       _h_ += this.opponent_ranks.hashCode();
/* 1863 */       _h_ += this.max_rank;
/* 1864 */       _h_ += this.win_num;
/* 1865 */       _h_ += this.lose_num;
/* 1866 */       _h_ += this.defend_win_num;
/* 1867 */       _h_ += this.defend_lose_num;
/* 1868 */       _h_ += this.records.hashCode();
/* 1869 */       _h_ = (int)(_h_ + this.init_time);
/* 1870 */       _h_ += this.award.hashCode();
/* 1871 */       _h_ += this.opponent_serial;
/* 1872 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1878 */       StringBuilder _sb_ = new StringBuilder();
/* 1879 */       _sb_.append("(");
/* 1880 */       _sb_.append(this.today_point);
/* 1881 */       _sb_.append(",");
/* 1882 */       _sb_.append(this.challenge_count);
/* 1883 */       _sb_.append(",");
/* 1884 */       _sb_.append(this.buy_count);
/* 1885 */       _sb_.append(",");
/* 1886 */       _sb_.append(this.refresh_time);
/* 1887 */       _sb_.append(",");
/* 1888 */       _sb_.append(this.opponent_ranks);
/* 1889 */       _sb_.append(",");
/* 1890 */       _sb_.append(this.max_rank);
/* 1891 */       _sb_.append(",");
/* 1892 */       _sb_.append(this.win_num);
/* 1893 */       _sb_.append(",");
/* 1894 */       _sb_.append(this.lose_num);
/* 1895 */       _sb_.append(",");
/* 1896 */       _sb_.append(this.defend_win_num);
/* 1897 */       _sb_.append(",");
/* 1898 */       _sb_.append(this.defend_lose_num);
/* 1899 */       _sb_.append(",");
/* 1900 */       _sb_.append(this.records);
/* 1901 */       _sb_.append(",");
/* 1902 */       _sb_.append(this.init_time);
/* 1903 */       _sb_.append(",");
/* 1904 */       _sb_.append(this.award);
/* 1905 */       _sb_.append(",");
/* 1906 */       _sb_.append(this.opponent_serial);
/* 1907 */       _sb_.append(")");
/* 1908 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetArenaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */