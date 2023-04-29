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
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class LonngBoatRaceMatch extends XBean implements xbean.LonngBoatRaceMatch
/*      */ {
/*      */   private long matchbegintimestamp;
/*      */   private int activityid;
/*      */   private int raceid;
/*      */   private int phaseno;
/*      */   private int roundno;
/*      */   private int timesno;
/*      */   private ArrayList<Integer> commandlist;
/*      */   private long endtimestamp;
/*      */   private int state;
/*      */   private HashMap<Long, xbean.LonngBoatRaceTeamStat> teamid2teamstat;
/*      */   private HashMap<Long, Integer> teamid2isallright;
/*      */   private HashMap<Long, Integer> roleid2israndom;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   40 */     this.matchbegintimestamp = 0L;
/*   41 */     this.activityid = 0;
/*   42 */     this.raceid = 0;
/*   43 */     this.phaseno = 0;
/*   44 */     this.roundno = 0;
/*   45 */     this.timesno = 0;
/*   46 */     this.commandlist.clear();
/*   47 */     this.endtimestamp = 0L;
/*   48 */     this.state = 0;
/*   49 */     this.teamid2teamstat.clear();
/*   50 */     this.teamid2isallright.clear();
/*   51 */     this.roleid2israndom.clear();
/*      */   }
/*      */   
/*      */   LonngBoatRaceMatch(int __, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     this.commandlist = new ArrayList();
/*   58 */     this.teamid2teamstat = new HashMap();
/*   59 */     this.teamid2isallright = new HashMap();
/*   60 */     this.roleid2israndom = new HashMap();
/*      */   }
/*      */   
/*      */   public LonngBoatRaceMatch()
/*      */   {
/*   65 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public LonngBoatRaceMatch(LonngBoatRaceMatch _o_)
/*      */   {
/*   70 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   LonngBoatRaceMatch(xbean.LonngBoatRaceMatch _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   75 */     super(_xp_, _vn_);
/*   76 */     if ((_o1_ instanceof LonngBoatRaceMatch)) { assign((LonngBoatRaceMatch)_o1_);
/*   77 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   78 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   79 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(LonngBoatRaceMatch _o_) {
/*   84 */     _o_._xdb_verify_unsafe_();
/*   85 */     this.matchbegintimestamp = _o_.matchbegintimestamp;
/*   86 */     this.activityid = _o_.activityid;
/*   87 */     this.raceid = _o_.raceid;
/*   88 */     this.phaseno = _o_.phaseno;
/*   89 */     this.roundno = _o_.roundno;
/*   90 */     this.timesno = _o_.timesno;
/*   91 */     this.commandlist = new ArrayList();
/*   92 */     this.commandlist.addAll(_o_.commandlist);
/*   93 */     this.endtimestamp = _o_.endtimestamp;
/*   94 */     this.state = _o_.state;
/*   95 */     this.teamid2teamstat = new HashMap();
/*   96 */     for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : _o_.teamid2teamstat.entrySet())
/*   97 */       this.teamid2teamstat.put(_e_.getKey(), new LonngBoatRaceTeamStat((xbean.LonngBoatRaceTeamStat)_e_.getValue(), this, "teamid2teamstat"));
/*   98 */     this.teamid2isallright = new HashMap();
/*   99 */     for (Map.Entry<Long, Integer> _e_ : _o_.teamid2isallright.entrySet())
/*  100 */       this.teamid2isallright.put(_e_.getKey(), _e_.getValue());
/*  101 */     this.roleid2israndom = new HashMap();
/*  102 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2israndom.entrySet()) {
/*  103 */       this.roleid2israndom.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  108 */     this.matchbegintimestamp = _o_.matchbegintimestamp;
/*  109 */     this.activityid = _o_.activityid;
/*  110 */     this.raceid = _o_.raceid;
/*  111 */     this.phaseno = _o_.phaseno;
/*  112 */     this.roundno = _o_.roundno;
/*  113 */     this.timesno = _o_.timesno;
/*  114 */     this.commandlist = new ArrayList();
/*  115 */     this.commandlist.addAll(_o_.commandlist);
/*  116 */     this.endtimestamp = _o_.endtimestamp;
/*  117 */     this.state = _o_.state;
/*  118 */     this.teamid2teamstat = new HashMap();
/*  119 */     for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : _o_.teamid2teamstat.entrySet())
/*  120 */       this.teamid2teamstat.put(_e_.getKey(), new LonngBoatRaceTeamStat((xbean.LonngBoatRaceTeamStat)_e_.getValue(), this, "teamid2teamstat"));
/*  121 */     this.teamid2isallright = new HashMap();
/*  122 */     for (Map.Entry<Long, Integer> _e_ : _o_.teamid2isallright.entrySet())
/*  123 */       this.teamid2isallright.put(_e_.getKey(), _e_.getValue());
/*  124 */     this.roleid2israndom = new HashMap();
/*  125 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2israndom.entrySet()) {
/*  126 */       this.roleid2israndom.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*  133 */     _os_.marshal(this.matchbegintimestamp);
/*  134 */     _os_.marshal(this.activityid);
/*  135 */     _os_.marshal(this.raceid);
/*  136 */     _os_.marshal(this.phaseno);
/*  137 */     _os_.marshal(this.roundno);
/*  138 */     _os_.marshal(this.timesno);
/*  139 */     _os_.compact_uint32(this.commandlist.size());
/*  140 */     for (Integer _v_ : this.commandlist)
/*      */     {
/*  142 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  144 */     _os_.marshal(this.endtimestamp);
/*  145 */     _os_.marshal(this.state);
/*  146 */     _os_.compact_uint32(this.teamid2teamstat.size());
/*  147 */     for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : this.teamid2teamstat.entrySet())
/*      */     {
/*  149 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  150 */       ((xbean.LonngBoatRaceTeamStat)_e_.getValue()).marshal(_os_);
/*      */     }
/*  152 */     _os_.compact_uint32(this.teamid2isallright.size());
/*  153 */     for (Map.Entry<Long, Integer> _e_ : this.teamid2isallright.entrySet())
/*      */     {
/*  155 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  156 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  158 */     _os_.compact_uint32(this.roleid2israndom.size());
/*  159 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2israndom.entrySet())
/*      */     {
/*  161 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  162 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  164 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  170 */     _xdb_verify_unsafe_();
/*  171 */     this.matchbegintimestamp = _os_.unmarshal_long();
/*  172 */     this.activityid = _os_.unmarshal_int();
/*  173 */     this.raceid = _os_.unmarshal_int();
/*  174 */     this.phaseno = _os_.unmarshal_int();
/*  175 */     this.roundno = _os_.unmarshal_int();
/*  176 */     this.timesno = _os_.unmarshal_int();
/*  177 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  179 */       int _v_ = 0;
/*  180 */       _v_ = _os_.unmarshal_int();
/*  181 */       this.commandlist.add(Integer.valueOf(_v_));
/*      */     }
/*  183 */     this.endtimestamp = _os_.unmarshal_long();
/*  184 */     this.state = _os_.unmarshal_int();
/*      */     
/*  186 */     int size = _os_.uncompact_uint32();
/*  187 */     if (size >= 12)
/*      */     {
/*  189 */       this.teamid2teamstat = new HashMap(size * 2);
/*      */     }
/*  191 */     for (; size > 0; size--)
/*      */     {
/*  193 */       long _k_ = 0L;
/*  194 */       _k_ = _os_.unmarshal_long();
/*  195 */       xbean.LonngBoatRaceTeamStat _v_ = new LonngBoatRaceTeamStat(0, this, "teamid2teamstat");
/*  196 */       _v_.unmarshal(_os_);
/*  197 */       this.teamid2teamstat.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  201 */     int size = _os_.uncompact_uint32();
/*  202 */     if (size >= 12)
/*      */     {
/*  204 */       this.teamid2isallright = new HashMap(size * 2);
/*      */     }
/*  206 */     for (; size > 0; size--)
/*      */     {
/*  208 */       long _k_ = 0L;
/*  209 */       _k_ = _os_.unmarshal_long();
/*  210 */       int _v_ = 0;
/*  211 */       _v_ = _os_.unmarshal_int();
/*  212 */       this.teamid2isallright.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  216 */     int size = _os_.uncompact_uint32();
/*  217 */     if (size >= 12)
/*      */     {
/*  219 */       this.roleid2israndom = new HashMap(size * 2);
/*      */     }
/*  221 */     for (; size > 0; size--)
/*      */     {
/*  223 */       long _k_ = 0L;
/*  224 */       _k_ = _os_.unmarshal_long();
/*  225 */       int _v_ = 0;
/*  226 */       _v_ = _os_.unmarshal_int();
/*  227 */       this.roleid2israndom.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  230 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  236 */     _xdb_verify_unsafe_();
/*  237 */     int _size_ = 0;
/*  238 */     _size_ += CodedOutputStream.computeInt64Size(1, this.matchbegintimestamp);
/*  239 */     _size_ += CodedOutputStream.computeInt32Size(2, this.activityid);
/*  240 */     _size_ += CodedOutputStream.computeInt32Size(3, this.raceid);
/*  241 */     _size_ += CodedOutputStream.computeInt32Size(4, this.phaseno);
/*  242 */     _size_ += CodedOutputStream.computeInt32Size(5, this.roundno);
/*  243 */     _size_ += CodedOutputStream.computeInt32Size(6, this.timesno);
/*  244 */     for (Integer _v_ : this.commandlist)
/*      */     {
/*  246 */       _size_ += CodedOutputStream.computeInt32Size(7, _v_.intValue());
/*      */     }
/*  248 */     _size_ += CodedOutputStream.computeInt64Size(8, this.endtimestamp);
/*  249 */     _size_ += CodedOutputStream.computeInt32Size(9, this.state);
/*  250 */     for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : this.teamid2teamstat.entrySet())
/*      */     {
/*  252 */       _size_ += CodedOutputStream.computeInt64Size(10, ((Long)_e_.getKey()).longValue());
/*  253 */       _size_ += CodedOutputStream.computeMessageSize(10, (ppbio.Message)_e_.getValue());
/*      */     }
/*  255 */     for (Map.Entry<Long, Integer> _e_ : this.teamid2isallright.entrySet())
/*      */     {
/*  257 */       _size_ += CodedOutputStream.computeInt64Size(11, ((Long)_e_.getKey()).longValue());
/*  258 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  260 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2israndom.entrySet())
/*      */     {
/*  262 */       _size_ += CodedOutputStream.computeInt64Size(12, ((Long)_e_.getKey()).longValue());
/*  263 */       _size_ += CodedOutputStream.computeInt32Size(12, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  265 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  274 */       _output_.writeInt64(1, this.matchbegintimestamp);
/*  275 */       _output_.writeInt32(2, this.activityid);
/*  276 */       _output_.writeInt32(3, this.raceid);
/*  277 */       _output_.writeInt32(4, this.phaseno);
/*  278 */       _output_.writeInt32(5, this.roundno);
/*  279 */       _output_.writeInt32(6, this.timesno);
/*  280 */       for (Integer _v_ : this.commandlist)
/*      */       {
/*  282 */         _output_.writeInt32(7, _v_.intValue());
/*      */       }
/*  284 */       _output_.writeInt64(8, this.endtimestamp);
/*  285 */       _output_.writeInt32(9, this.state);
/*  286 */       for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : this.teamid2teamstat.entrySet())
/*      */       {
/*  288 */         _output_.writeInt64(10, ((Long)_e_.getKey()).longValue());
/*  289 */         _output_.writeMessage(10, (ppbio.Message)_e_.getValue());
/*      */       }
/*  291 */       for (Map.Entry<Long, Integer> _e_ : this.teamid2isallright.entrySet())
/*      */       {
/*  293 */         _output_.writeInt64(11, ((Long)_e_.getKey()).longValue());
/*  294 */         _output_.writeInt32(11, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  296 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2israndom.entrySet())
/*      */       {
/*  298 */         _output_.writeInt64(12, ((Long)_e_.getKey()).longValue());
/*  299 */         _output_.writeInt32(12, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  304 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  306 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  315 */       boolean done = false;
/*  316 */       while (!done)
/*      */       {
/*  318 */         int tag = _input_.readTag();
/*  319 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  323 */           done = true;
/*  324 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  328 */           this.matchbegintimestamp = _input_.readInt64();
/*  329 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  333 */           this.activityid = _input_.readInt32();
/*  334 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  338 */           this.raceid = _input_.readInt32();
/*  339 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  343 */           this.phaseno = _input_.readInt32();
/*  344 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  348 */           this.roundno = _input_.readInt32();
/*  349 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  353 */           this.timesno = _input_.readInt32();
/*  354 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  358 */           int _v_ = 0;
/*  359 */           _v_ = _input_.readInt32();
/*  360 */           this.commandlist.add(Integer.valueOf(_v_));
/*  361 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  365 */           this.endtimestamp = _input_.readInt64();
/*  366 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  370 */           this.state = _input_.readInt32();
/*  371 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  375 */           long _k_ = 0L;
/*  376 */           _k_ = _input_.readInt64();
/*  377 */           int readTag = _input_.readTag();
/*  378 */           if (82 != readTag)
/*      */           {
/*  380 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  382 */           xbean.LonngBoatRaceTeamStat _v_ = new LonngBoatRaceTeamStat(0, this, "teamid2teamstat");
/*  383 */           _input_.readMessage(_v_);
/*  384 */           this.teamid2teamstat.put(Long.valueOf(_k_), _v_);
/*  385 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  389 */           long _k_ = 0L;
/*  390 */           _k_ = _input_.readInt64();
/*  391 */           int readTag = _input_.readTag();
/*  392 */           if (88 != readTag)
/*      */           {
/*  394 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  396 */           int _v_ = 0;
/*  397 */           _v_ = _input_.readInt32();
/*  398 */           this.teamid2isallright.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  399 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  403 */           long _k_ = 0L;
/*  404 */           _k_ = _input_.readInt64();
/*  405 */           int readTag = _input_.readTag();
/*  406 */           if (96 != readTag)
/*      */           {
/*  408 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  410 */           int _v_ = 0;
/*  411 */           _v_ = _input_.readInt32();
/*  412 */           this.roleid2israndom.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  413 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  417 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  419 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  428 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  432 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  434 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LonngBoatRaceMatch copy()
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     return new LonngBoatRaceMatch(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LonngBoatRaceMatch toData()
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.LonngBoatRaceMatch toBean()
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     return new LonngBoatRaceMatch(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LonngBoatRaceMatch toDataIf()
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*  461 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.LonngBoatRaceMatch toBeanIf()
/*      */   {
/*  466 */     _xdb_verify_unsafe_();
/*  467 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMatchbegintimestamp()
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*  482 */     return this.matchbegintimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActivityid()
/*      */   {
/*  489 */     _xdb_verify_unsafe_();
/*  490 */     return this.activityid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRaceid()
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     return this.raceid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPhaseno()
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     return this.phaseno;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRoundno()
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     return this.roundno;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTimesno()
/*      */   {
/*  521 */     _xdb_verify_unsafe_();
/*  522 */     return this.timesno;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getCommandlist()
/*      */   {
/*  529 */     _xdb_verify_unsafe_();
/*  530 */     return Logs.logList(new LogKey(this, "commandlist"), this.commandlist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getCommandlistAsData()
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*      */     
/*  538 */     LonngBoatRaceMatch _o_ = this;
/*  539 */     List<Integer> commandlist = new ArrayList();
/*  540 */     commandlist.addAll(_o_.commandlist);
/*  541 */     return commandlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtimestamp()
/*      */   {
/*  548 */     _xdb_verify_unsafe_();
/*  549 */     return this.endtimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*  557 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.LonngBoatRaceTeamStat> getTeamid2teamstat()
/*      */   {
/*  564 */     _xdb_verify_unsafe_();
/*  565 */     return Logs.logMap(new LogKey(this, "teamid2teamstat"), this.teamid2teamstat);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.LonngBoatRaceTeamStat> getTeamid2teamstatAsData()
/*      */   {
/*  572 */     _xdb_verify_unsafe_();
/*      */     
/*  574 */     LonngBoatRaceMatch _o_ = this;
/*  575 */     Map<Long, xbean.LonngBoatRaceTeamStat> teamid2teamstat = new HashMap();
/*  576 */     for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : _o_.teamid2teamstat.entrySet())
/*  577 */       teamid2teamstat.put(_e_.getKey(), new LonngBoatRaceTeamStat.Data((xbean.LonngBoatRaceTeamStat)_e_.getValue()));
/*  578 */     return teamid2teamstat;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getTeamid2isallright()
/*      */   {
/*  585 */     _xdb_verify_unsafe_();
/*  586 */     return Logs.logMap(new LogKey(this, "teamid2isallright"), this.teamid2isallright);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getTeamid2isallrightAsData()
/*      */   {
/*  593 */     _xdb_verify_unsafe_();
/*      */     
/*  595 */     LonngBoatRaceMatch _o_ = this;
/*  596 */     Map<Long, Integer> teamid2isallright = new HashMap();
/*  597 */     for (Map.Entry<Long, Integer> _e_ : _o_.teamid2isallright.entrySet())
/*  598 */       teamid2isallright.put(_e_.getKey(), _e_.getValue());
/*  599 */     return teamid2isallright;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRoleid2israndom()
/*      */   {
/*  606 */     _xdb_verify_unsafe_();
/*  607 */     return Logs.logMap(new LogKey(this, "roleid2israndom"), this.roleid2israndom);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRoleid2israndomAsData()
/*      */   {
/*  614 */     _xdb_verify_unsafe_();
/*      */     
/*  616 */     LonngBoatRaceMatch _o_ = this;
/*  617 */     Map<Long, Integer> roleid2israndom = new HashMap();
/*  618 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2israndom.entrySet())
/*  619 */       roleid2israndom.put(_e_.getKey(), _e_.getValue());
/*  620 */     return roleid2israndom;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMatchbegintimestamp(long _v_)
/*      */   {
/*  627 */     _xdb_verify_unsafe_();
/*  628 */     Logs.logIf(new LogKey(this, "matchbegintimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  632 */         new xdb.logs.LogLong(this, LonngBoatRaceMatch.this.matchbegintimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  636 */             LonngBoatRaceMatch.this.matchbegintimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  640 */     });
/*  641 */     this.matchbegintimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivityid(int _v_)
/*      */   {
/*  648 */     _xdb_verify_unsafe_();
/*  649 */     Logs.logIf(new LogKey(this, "activityid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  653 */         new LogInt(this, LonngBoatRaceMatch.this.activityid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  657 */             LonngBoatRaceMatch.this.activityid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  661 */     });
/*  662 */     this.activityid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRaceid(int _v_)
/*      */   {
/*  669 */     _xdb_verify_unsafe_();
/*  670 */     Logs.logIf(new LogKey(this, "raceid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  674 */         new LogInt(this, LonngBoatRaceMatch.this.raceid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  678 */             LonngBoatRaceMatch.this.raceid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  682 */     });
/*  683 */     this.raceid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPhaseno(int _v_)
/*      */   {
/*  690 */     _xdb_verify_unsafe_();
/*  691 */     Logs.logIf(new LogKey(this, "phaseno")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  695 */         new LogInt(this, LonngBoatRaceMatch.this.phaseno)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  699 */             LonngBoatRaceMatch.this.phaseno = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  703 */     });
/*  704 */     this.phaseno = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoundno(int _v_)
/*      */   {
/*  711 */     _xdb_verify_unsafe_();
/*  712 */     Logs.logIf(new LogKey(this, "roundno")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  716 */         new LogInt(this, LonngBoatRaceMatch.this.roundno)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  720 */             LonngBoatRaceMatch.this.roundno = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  724 */     });
/*  725 */     this.roundno = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTimesno(int _v_)
/*      */   {
/*  732 */     _xdb_verify_unsafe_();
/*  733 */     Logs.logIf(new LogKey(this, "timesno")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  737 */         new LogInt(this, LonngBoatRaceMatch.this.timesno)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  741 */             LonngBoatRaceMatch.this.timesno = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  745 */     });
/*  746 */     this.timesno = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtimestamp(long _v_)
/*      */   {
/*  753 */     _xdb_verify_unsafe_();
/*  754 */     Logs.logIf(new LogKey(this, "endtimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  758 */         new xdb.logs.LogLong(this, LonngBoatRaceMatch.this.endtimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  762 */             LonngBoatRaceMatch.this.endtimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  766 */     });
/*  767 */     this.endtimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  774 */     _xdb_verify_unsafe_();
/*  775 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  779 */         new LogInt(this, LonngBoatRaceMatch.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  783 */             LonngBoatRaceMatch.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  787 */     });
/*  788 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  794 */     _xdb_verify_unsafe_();
/*  795 */     LonngBoatRaceMatch _o_ = null;
/*  796 */     if ((_o1_ instanceof LonngBoatRaceMatch)) { _o_ = (LonngBoatRaceMatch)_o1_;
/*  797 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  798 */       return false;
/*  799 */     if (this.matchbegintimestamp != _o_.matchbegintimestamp) return false;
/*  800 */     if (this.activityid != _o_.activityid) return false;
/*  801 */     if (this.raceid != _o_.raceid) return false;
/*  802 */     if (this.phaseno != _o_.phaseno) return false;
/*  803 */     if (this.roundno != _o_.roundno) return false;
/*  804 */     if (this.timesno != _o_.timesno) return false;
/*  805 */     if (!this.commandlist.equals(_o_.commandlist)) return false;
/*  806 */     if (this.endtimestamp != _o_.endtimestamp) return false;
/*  807 */     if (this.state != _o_.state) return false;
/*  808 */     if (!this.teamid2teamstat.equals(_o_.teamid2teamstat)) return false;
/*  809 */     if (!this.teamid2isallright.equals(_o_.teamid2isallright)) return false;
/*  810 */     if (!this.roleid2israndom.equals(_o_.roleid2israndom)) return false;
/*  811 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  817 */     _xdb_verify_unsafe_();
/*  818 */     int _h_ = 0;
/*  819 */     _h_ = (int)(_h_ + this.matchbegintimestamp);
/*  820 */     _h_ += this.activityid;
/*  821 */     _h_ += this.raceid;
/*  822 */     _h_ += this.phaseno;
/*  823 */     _h_ += this.roundno;
/*  824 */     _h_ += this.timesno;
/*  825 */     _h_ += this.commandlist.hashCode();
/*  826 */     _h_ = (int)(_h_ + this.endtimestamp);
/*  827 */     _h_ += this.state;
/*  828 */     _h_ += this.teamid2teamstat.hashCode();
/*  829 */     _h_ += this.teamid2isallright.hashCode();
/*  830 */     _h_ += this.roleid2israndom.hashCode();
/*  831 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  837 */     _xdb_verify_unsafe_();
/*  838 */     StringBuilder _sb_ = new StringBuilder();
/*  839 */     _sb_.append("(");
/*  840 */     _sb_.append(this.matchbegintimestamp);
/*  841 */     _sb_.append(",");
/*  842 */     _sb_.append(this.activityid);
/*  843 */     _sb_.append(",");
/*  844 */     _sb_.append(this.raceid);
/*  845 */     _sb_.append(",");
/*  846 */     _sb_.append(this.phaseno);
/*  847 */     _sb_.append(",");
/*  848 */     _sb_.append(this.roundno);
/*  849 */     _sb_.append(",");
/*  850 */     _sb_.append(this.timesno);
/*  851 */     _sb_.append(",");
/*  852 */     _sb_.append(this.commandlist);
/*  853 */     _sb_.append(",");
/*  854 */     _sb_.append(this.endtimestamp);
/*  855 */     _sb_.append(",");
/*  856 */     _sb_.append(this.state);
/*  857 */     _sb_.append(",");
/*  858 */     _sb_.append(this.teamid2teamstat);
/*  859 */     _sb_.append(",");
/*  860 */     _sb_.append(this.teamid2isallright);
/*  861 */     _sb_.append(",");
/*  862 */     _sb_.append(this.roleid2israndom);
/*  863 */     _sb_.append(")");
/*  864 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  870 */     ListenableBean lb = new ListenableBean();
/*  871 */     lb.add(new ListenableChanged().setVarName("matchbegintimestamp"));
/*  872 */     lb.add(new ListenableChanged().setVarName("activityid"));
/*  873 */     lb.add(new ListenableChanged().setVarName("raceid"));
/*  874 */     lb.add(new ListenableChanged().setVarName("phaseno"));
/*  875 */     lb.add(new ListenableChanged().setVarName("roundno"));
/*  876 */     lb.add(new ListenableChanged().setVarName("timesno"));
/*  877 */     lb.add(new ListenableChanged().setVarName("commandlist"));
/*  878 */     lb.add(new ListenableChanged().setVarName("endtimestamp"));
/*  879 */     lb.add(new ListenableChanged().setVarName("state"));
/*  880 */     lb.add(new ListenableMap().setVarName("teamid2teamstat"));
/*  881 */     lb.add(new ListenableMap().setVarName("teamid2isallright"));
/*  882 */     lb.add(new ListenableMap().setVarName("roleid2israndom"));
/*  883 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.LonngBoatRaceMatch {
/*      */     private Const() {}
/*      */     
/*      */     LonngBoatRaceMatch nThis() {
/*  890 */       return LonngBoatRaceMatch.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  896 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceMatch copy()
/*      */     {
/*  902 */       return LonngBoatRaceMatch.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceMatch toData()
/*      */     {
/*  908 */       return LonngBoatRaceMatch.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.LonngBoatRaceMatch toBean()
/*      */     {
/*  913 */       return LonngBoatRaceMatch.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceMatch toDataIf()
/*      */     {
/*  919 */       return LonngBoatRaceMatch.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.LonngBoatRaceMatch toBeanIf()
/*      */     {
/*  924 */       return LonngBoatRaceMatch.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMatchbegintimestamp()
/*      */     {
/*  931 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*  932 */       return LonngBoatRaceMatch.this.matchbegintimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivityid()
/*      */     {
/*  939 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*  940 */       return LonngBoatRaceMatch.this.activityid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRaceid()
/*      */     {
/*  947 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*  948 */       return LonngBoatRaceMatch.this.raceid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPhaseno()
/*      */     {
/*  955 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*  956 */       return LonngBoatRaceMatch.this.phaseno;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRoundno()
/*      */     {
/*  963 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*  964 */       return LonngBoatRaceMatch.this.roundno;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTimesno()
/*      */     {
/*  971 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*  972 */       return LonngBoatRaceMatch.this.timesno;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getCommandlist()
/*      */     {
/*  979 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*  980 */       return xdb.Consts.constList(LonngBoatRaceMatch.this.commandlist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getCommandlistAsData()
/*      */     {
/*  986 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*      */       
/*  988 */       LonngBoatRaceMatch _o_ = LonngBoatRaceMatch.this;
/*  989 */       List<Integer> commandlist = new ArrayList();
/*  990 */       commandlist.addAll(_o_.commandlist);
/*  991 */       return commandlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtimestamp()
/*      */     {
/*  998 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*  999 */       return LonngBoatRaceMatch.this.endtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1006 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1007 */       return LonngBoatRaceMatch.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceTeamStat> getTeamid2teamstat()
/*      */     {
/* 1014 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1015 */       return xdb.Consts.constMap(LonngBoatRaceMatch.this.teamid2teamstat);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceTeamStat> getTeamid2teamstatAsData()
/*      */     {
/* 1022 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*      */       
/* 1024 */       LonngBoatRaceMatch _o_ = LonngBoatRaceMatch.this;
/* 1025 */       Map<Long, xbean.LonngBoatRaceTeamStat> teamid2teamstat = new HashMap();
/* 1026 */       for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : _o_.teamid2teamstat.entrySet())
/* 1027 */         teamid2teamstat.put(_e_.getKey(), new LonngBoatRaceTeamStat.Data((xbean.LonngBoatRaceTeamStat)_e_.getValue()));
/* 1028 */       return teamid2teamstat;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getTeamid2isallright()
/*      */     {
/* 1035 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1036 */       return xdb.Consts.constMap(LonngBoatRaceMatch.this.teamid2isallright);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getTeamid2isallrightAsData()
/*      */     {
/* 1043 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*      */       
/* 1045 */       LonngBoatRaceMatch _o_ = LonngBoatRaceMatch.this;
/* 1046 */       Map<Long, Integer> teamid2isallright = new HashMap();
/* 1047 */       for (Map.Entry<Long, Integer> _e_ : _o_.teamid2isallright.entrySet())
/* 1048 */         teamid2isallright.put(_e_.getKey(), _e_.getValue());
/* 1049 */       return teamid2isallright;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoleid2israndom()
/*      */     {
/* 1056 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1057 */       return xdb.Consts.constMap(LonngBoatRaceMatch.this.roleid2israndom);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoleid2israndomAsData()
/*      */     {
/* 1064 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/*      */       
/* 1066 */       LonngBoatRaceMatch _o_ = LonngBoatRaceMatch.this;
/* 1067 */       Map<Long, Integer> roleid2israndom = new HashMap();
/* 1068 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2israndom.entrySet())
/* 1069 */         roleid2israndom.put(_e_.getKey(), _e_.getValue());
/* 1070 */       return roleid2israndom;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMatchbegintimestamp(long _v_)
/*      */     {
/* 1077 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1078 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivityid(int _v_)
/*      */     {
/* 1085 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1086 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRaceid(int _v_)
/*      */     {
/* 1093 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1094 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPhaseno(int _v_)
/*      */     {
/* 1101 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1102 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoundno(int _v_)
/*      */     {
/* 1109 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1110 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimesno(int _v_)
/*      */     {
/* 1117 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1118 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtimestamp(long _v_)
/*      */     {
/* 1125 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1126 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1133 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1134 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1140 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1141 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1147 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1148 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1154 */       return LonngBoatRaceMatch.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1160 */       return LonngBoatRaceMatch.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1166 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1167 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1173 */       return LonngBoatRaceMatch.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1179 */       return LonngBoatRaceMatch.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1185 */       LonngBoatRaceMatch.this._xdb_verify_unsafe_();
/* 1186 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1192 */       return LonngBoatRaceMatch.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1198 */       return LonngBoatRaceMatch.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1204 */       return LonngBoatRaceMatch.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1210 */       return LonngBoatRaceMatch.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1216 */       return LonngBoatRaceMatch.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1222 */       return LonngBoatRaceMatch.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1228 */       return LonngBoatRaceMatch.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.LonngBoatRaceMatch
/*      */   {
/*      */     private long matchbegintimestamp;
/*      */     
/*      */     private int activityid;
/*      */     
/*      */     private int raceid;
/*      */     
/*      */     private int phaseno;
/*      */     
/*      */     private int roundno;
/*      */     
/*      */     private int timesno;
/*      */     
/*      */     private ArrayList<Integer> commandlist;
/*      */     
/*      */     private long endtimestamp;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private HashMap<Long, xbean.LonngBoatRaceTeamStat> teamid2teamstat;
/*      */     
/*      */     private HashMap<Long, Integer> teamid2isallright;
/*      */     
/*      */     private HashMap<Long, Integer> roleid2israndom;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1262 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1267 */       this.commandlist = new ArrayList();
/* 1268 */       this.teamid2teamstat = new HashMap();
/* 1269 */       this.teamid2isallright = new HashMap();
/* 1270 */       this.roleid2israndom = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.LonngBoatRaceMatch _o1_)
/*      */     {
/* 1275 */       if ((_o1_ instanceof LonngBoatRaceMatch)) { assign((LonngBoatRaceMatch)_o1_);
/* 1276 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1277 */       } else if ((_o1_ instanceof LonngBoatRaceMatch.Const)) assign(((LonngBoatRaceMatch.Const)_o1_).nThis()); else {
/* 1278 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(LonngBoatRaceMatch _o_) {
/* 1283 */       this.matchbegintimestamp = _o_.matchbegintimestamp;
/* 1284 */       this.activityid = _o_.activityid;
/* 1285 */       this.raceid = _o_.raceid;
/* 1286 */       this.phaseno = _o_.phaseno;
/* 1287 */       this.roundno = _o_.roundno;
/* 1288 */       this.timesno = _o_.timesno;
/* 1289 */       this.commandlist = new ArrayList();
/* 1290 */       this.commandlist.addAll(_o_.commandlist);
/* 1291 */       this.endtimestamp = _o_.endtimestamp;
/* 1292 */       this.state = _o_.state;
/* 1293 */       this.teamid2teamstat = new HashMap();
/* 1294 */       for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : _o_.teamid2teamstat.entrySet())
/* 1295 */         this.teamid2teamstat.put(_e_.getKey(), new LonngBoatRaceTeamStat.Data((xbean.LonngBoatRaceTeamStat)_e_.getValue()));
/* 1296 */       this.teamid2isallright = new HashMap();
/* 1297 */       for (Map.Entry<Long, Integer> _e_ : _o_.teamid2isallright.entrySet())
/* 1298 */         this.teamid2isallright.put(_e_.getKey(), _e_.getValue());
/* 1299 */       this.roleid2israndom = new HashMap();
/* 1300 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2israndom.entrySet()) {
/* 1301 */         this.roleid2israndom.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1306 */       this.matchbegintimestamp = _o_.matchbegintimestamp;
/* 1307 */       this.activityid = _o_.activityid;
/* 1308 */       this.raceid = _o_.raceid;
/* 1309 */       this.phaseno = _o_.phaseno;
/* 1310 */       this.roundno = _o_.roundno;
/* 1311 */       this.timesno = _o_.timesno;
/* 1312 */       this.commandlist = new ArrayList();
/* 1313 */       this.commandlist.addAll(_o_.commandlist);
/* 1314 */       this.endtimestamp = _o_.endtimestamp;
/* 1315 */       this.state = _o_.state;
/* 1316 */       this.teamid2teamstat = new HashMap();
/* 1317 */       for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : _o_.teamid2teamstat.entrySet())
/* 1318 */         this.teamid2teamstat.put(_e_.getKey(), new LonngBoatRaceTeamStat.Data((xbean.LonngBoatRaceTeamStat)_e_.getValue()));
/* 1319 */       this.teamid2isallright = new HashMap();
/* 1320 */       for (Map.Entry<Long, Integer> _e_ : _o_.teamid2isallright.entrySet())
/* 1321 */         this.teamid2isallright.put(_e_.getKey(), _e_.getValue());
/* 1322 */       this.roleid2israndom = new HashMap();
/* 1323 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2israndom.entrySet()) {
/* 1324 */         this.roleid2israndom.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1330 */       _os_.marshal(this.matchbegintimestamp);
/* 1331 */       _os_.marshal(this.activityid);
/* 1332 */       _os_.marshal(this.raceid);
/* 1333 */       _os_.marshal(this.phaseno);
/* 1334 */       _os_.marshal(this.roundno);
/* 1335 */       _os_.marshal(this.timesno);
/* 1336 */       _os_.compact_uint32(this.commandlist.size());
/* 1337 */       for (Integer _v_ : this.commandlist)
/*      */       {
/* 1339 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1341 */       _os_.marshal(this.endtimestamp);
/* 1342 */       _os_.marshal(this.state);
/* 1343 */       _os_.compact_uint32(this.teamid2teamstat.size());
/* 1344 */       for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : this.teamid2teamstat.entrySet())
/*      */       {
/* 1346 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1347 */         ((xbean.LonngBoatRaceTeamStat)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1349 */       _os_.compact_uint32(this.teamid2isallright.size());
/* 1350 */       for (Map.Entry<Long, Integer> _e_ : this.teamid2isallright.entrySet())
/*      */       {
/* 1352 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1353 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1355 */       _os_.compact_uint32(this.roleid2israndom.size());
/* 1356 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2israndom.entrySet())
/*      */       {
/* 1358 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1359 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1361 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1367 */       this.matchbegintimestamp = _os_.unmarshal_long();
/* 1368 */       this.activityid = _os_.unmarshal_int();
/* 1369 */       this.raceid = _os_.unmarshal_int();
/* 1370 */       this.phaseno = _os_.unmarshal_int();
/* 1371 */       this.roundno = _os_.unmarshal_int();
/* 1372 */       this.timesno = _os_.unmarshal_int();
/* 1373 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1375 */         int _v_ = 0;
/* 1376 */         _v_ = _os_.unmarshal_int();
/* 1377 */         this.commandlist.add(Integer.valueOf(_v_));
/*      */       }
/* 1379 */       this.endtimestamp = _os_.unmarshal_long();
/* 1380 */       this.state = _os_.unmarshal_int();
/*      */       
/* 1382 */       int size = _os_.uncompact_uint32();
/* 1383 */       if (size >= 12)
/*      */       {
/* 1385 */         this.teamid2teamstat = new HashMap(size * 2);
/*      */       }
/* 1387 */       for (; size > 0; size--)
/*      */       {
/* 1389 */         long _k_ = 0L;
/* 1390 */         _k_ = _os_.unmarshal_long();
/* 1391 */         xbean.LonngBoatRaceTeamStat _v_ = xbean.Pod.newLonngBoatRaceTeamStatData();
/* 1392 */         _v_.unmarshal(_os_);
/* 1393 */         this.teamid2teamstat.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1397 */       int size = _os_.uncompact_uint32();
/* 1398 */       if (size >= 12)
/*      */       {
/* 1400 */         this.teamid2isallright = new HashMap(size * 2);
/*      */       }
/* 1402 */       for (; size > 0; size--)
/*      */       {
/* 1404 */         long _k_ = 0L;
/* 1405 */         _k_ = _os_.unmarshal_long();
/* 1406 */         int _v_ = 0;
/* 1407 */         _v_ = _os_.unmarshal_int();
/* 1408 */         this.teamid2isallright.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 1412 */       int size = _os_.uncompact_uint32();
/* 1413 */       if (size >= 12)
/*      */       {
/* 1415 */         this.roleid2israndom = new HashMap(size * 2);
/*      */       }
/* 1417 */       for (; size > 0; size--)
/*      */       {
/* 1419 */         long _k_ = 0L;
/* 1420 */         _k_ = _os_.unmarshal_long();
/* 1421 */         int _v_ = 0;
/* 1422 */         _v_ = _os_.unmarshal_int();
/* 1423 */         this.roleid2israndom.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1426 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1432 */       int _size_ = 0;
/* 1433 */       _size_ += CodedOutputStream.computeInt64Size(1, this.matchbegintimestamp);
/* 1434 */       _size_ += CodedOutputStream.computeInt32Size(2, this.activityid);
/* 1435 */       _size_ += CodedOutputStream.computeInt32Size(3, this.raceid);
/* 1436 */       _size_ += CodedOutputStream.computeInt32Size(4, this.phaseno);
/* 1437 */       _size_ += CodedOutputStream.computeInt32Size(5, this.roundno);
/* 1438 */       _size_ += CodedOutputStream.computeInt32Size(6, this.timesno);
/* 1439 */       for (Integer _v_ : this.commandlist)
/*      */       {
/* 1441 */         _size_ += CodedOutputStream.computeInt32Size(7, _v_.intValue());
/*      */       }
/* 1443 */       _size_ += CodedOutputStream.computeInt64Size(8, this.endtimestamp);
/* 1444 */       _size_ += CodedOutputStream.computeInt32Size(9, this.state);
/* 1445 */       for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : this.teamid2teamstat.entrySet())
/*      */       {
/* 1447 */         _size_ += CodedOutputStream.computeInt64Size(10, ((Long)_e_.getKey()).longValue());
/* 1448 */         _size_ += CodedOutputStream.computeMessageSize(10, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1450 */       for (Map.Entry<Long, Integer> _e_ : this.teamid2isallright.entrySet())
/*      */       {
/* 1452 */         _size_ += CodedOutputStream.computeInt64Size(11, ((Long)_e_.getKey()).longValue());
/* 1453 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1455 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2israndom.entrySet())
/*      */       {
/* 1457 */         _size_ += CodedOutputStream.computeInt64Size(12, ((Long)_e_.getKey()).longValue());
/* 1458 */         _size_ += CodedOutputStream.computeInt32Size(12, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1460 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1468 */         _output_.writeInt64(1, this.matchbegintimestamp);
/* 1469 */         _output_.writeInt32(2, this.activityid);
/* 1470 */         _output_.writeInt32(3, this.raceid);
/* 1471 */         _output_.writeInt32(4, this.phaseno);
/* 1472 */         _output_.writeInt32(5, this.roundno);
/* 1473 */         _output_.writeInt32(6, this.timesno);
/* 1474 */         for (Integer _v_ : this.commandlist)
/*      */         {
/* 1476 */           _output_.writeInt32(7, _v_.intValue());
/*      */         }
/* 1478 */         _output_.writeInt64(8, this.endtimestamp);
/* 1479 */         _output_.writeInt32(9, this.state);
/* 1480 */         for (Map.Entry<Long, xbean.LonngBoatRaceTeamStat> _e_ : this.teamid2teamstat.entrySet())
/*      */         {
/* 1482 */           _output_.writeInt64(10, ((Long)_e_.getKey()).longValue());
/* 1483 */           _output_.writeMessage(10, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1485 */         for (Map.Entry<Long, Integer> _e_ : this.teamid2isallright.entrySet())
/*      */         {
/* 1487 */           _output_.writeInt64(11, ((Long)_e_.getKey()).longValue());
/* 1488 */           _output_.writeInt32(11, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1490 */         for (Map.Entry<Long, Integer> _e_ : this.roleid2israndom.entrySet())
/*      */         {
/* 1492 */           _output_.writeInt64(12, ((Long)_e_.getKey()).longValue());
/* 1493 */           _output_.writeInt32(12, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1498 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1500 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1508 */         boolean done = false;
/* 1509 */         while (!done)
/*      */         {
/* 1511 */           int tag = _input_.readTag();
/* 1512 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1516 */             done = true;
/* 1517 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1521 */             this.matchbegintimestamp = _input_.readInt64();
/* 1522 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1526 */             this.activityid = _input_.readInt32();
/* 1527 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1531 */             this.raceid = _input_.readInt32();
/* 1532 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1536 */             this.phaseno = _input_.readInt32();
/* 1537 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1541 */             this.roundno = _input_.readInt32();
/* 1542 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1546 */             this.timesno = _input_.readInt32();
/* 1547 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1551 */             int _v_ = 0;
/* 1552 */             _v_ = _input_.readInt32();
/* 1553 */             this.commandlist.add(Integer.valueOf(_v_));
/* 1554 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1558 */             this.endtimestamp = _input_.readInt64();
/* 1559 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1563 */             this.state = _input_.readInt32();
/* 1564 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1568 */             long _k_ = 0L;
/* 1569 */             _k_ = _input_.readInt64();
/* 1570 */             int readTag = _input_.readTag();
/* 1571 */             if (82 != readTag)
/*      */             {
/* 1573 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1575 */             xbean.LonngBoatRaceTeamStat _v_ = xbean.Pod.newLonngBoatRaceTeamStatData();
/* 1576 */             _input_.readMessage(_v_);
/* 1577 */             this.teamid2teamstat.put(Long.valueOf(_k_), _v_);
/* 1578 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1582 */             long _k_ = 0L;
/* 1583 */             _k_ = _input_.readInt64();
/* 1584 */             int readTag = _input_.readTag();
/* 1585 */             if (88 != readTag)
/*      */             {
/* 1587 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1589 */             int _v_ = 0;
/* 1590 */             _v_ = _input_.readInt32();
/* 1591 */             this.teamid2isallright.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 1592 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1596 */             long _k_ = 0L;
/* 1597 */             _k_ = _input_.readInt64();
/* 1598 */             int readTag = _input_.readTag();
/* 1599 */             if (96 != readTag)
/*      */             {
/* 1601 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1603 */             int _v_ = 0;
/* 1604 */             _v_ = _input_.readInt32();
/* 1605 */             this.roleid2israndom.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 1606 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1610 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1612 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1621 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1625 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1627 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceMatch copy()
/*      */     {
/* 1633 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceMatch toData()
/*      */     {
/* 1639 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.LonngBoatRaceMatch toBean()
/*      */     {
/* 1644 */       return new LonngBoatRaceMatch(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceMatch toDataIf()
/*      */     {
/* 1650 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.LonngBoatRaceMatch toBeanIf()
/*      */     {
/* 1655 */       return new LonngBoatRaceMatch(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1665 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1669 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1673 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1677 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1681 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1685 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMatchbegintimestamp()
/*      */     {
/* 1692 */       return this.matchbegintimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivityid()
/*      */     {
/* 1699 */       return this.activityid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRaceid()
/*      */     {
/* 1706 */       return this.raceid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPhaseno()
/*      */     {
/* 1713 */       return this.phaseno;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRoundno()
/*      */     {
/* 1720 */       return this.roundno;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTimesno()
/*      */     {
/* 1727 */       return this.timesno;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getCommandlist()
/*      */     {
/* 1734 */       return this.commandlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getCommandlistAsData()
/*      */     {
/* 1741 */       return this.commandlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtimestamp()
/*      */     {
/* 1748 */       return this.endtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1755 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceTeamStat> getTeamid2teamstat()
/*      */     {
/* 1762 */       return this.teamid2teamstat;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceTeamStat> getTeamid2teamstatAsData()
/*      */     {
/* 1769 */       return this.teamid2teamstat;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getTeamid2isallright()
/*      */     {
/* 1776 */       return this.teamid2isallright;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getTeamid2isallrightAsData()
/*      */     {
/* 1783 */       return this.teamid2isallright;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoleid2israndom()
/*      */     {
/* 1790 */       return this.roleid2israndom;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoleid2israndomAsData()
/*      */     {
/* 1797 */       return this.roleid2israndom;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMatchbegintimestamp(long _v_)
/*      */     {
/* 1804 */       this.matchbegintimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivityid(int _v_)
/*      */     {
/* 1811 */       this.activityid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRaceid(int _v_)
/*      */     {
/* 1818 */       this.raceid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPhaseno(int _v_)
/*      */     {
/* 1825 */       this.phaseno = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoundno(int _v_)
/*      */     {
/* 1832 */       this.roundno = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimesno(int _v_)
/*      */     {
/* 1839 */       this.timesno = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtimestamp(long _v_)
/*      */     {
/* 1846 */       this.endtimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1853 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1859 */       if (!(_o1_ instanceof Data)) return false;
/* 1860 */       Data _o_ = (Data)_o1_;
/* 1861 */       if (this.matchbegintimestamp != _o_.matchbegintimestamp) return false;
/* 1862 */       if (this.activityid != _o_.activityid) return false;
/* 1863 */       if (this.raceid != _o_.raceid) return false;
/* 1864 */       if (this.phaseno != _o_.phaseno) return false;
/* 1865 */       if (this.roundno != _o_.roundno) return false;
/* 1866 */       if (this.timesno != _o_.timesno) return false;
/* 1867 */       if (!this.commandlist.equals(_o_.commandlist)) return false;
/* 1868 */       if (this.endtimestamp != _o_.endtimestamp) return false;
/* 1869 */       if (this.state != _o_.state) return false;
/* 1870 */       if (!this.teamid2teamstat.equals(_o_.teamid2teamstat)) return false;
/* 1871 */       if (!this.teamid2isallright.equals(_o_.teamid2isallright)) return false;
/* 1872 */       if (!this.roleid2israndom.equals(_o_.roleid2israndom)) return false;
/* 1873 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1879 */       int _h_ = 0;
/* 1880 */       _h_ = (int)(_h_ + this.matchbegintimestamp);
/* 1881 */       _h_ += this.activityid;
/* 1882 */       _h_ += this.raceid;
/* 1883 */       _h_ += this.phaseno;
/* 1884 */       _h_ += this.roundno;
/* 1885 */       _h_ += this.timesno;
/* 1886 */       _h_ += this.commandlist.hashCode();
/* 1887 */       _h_ = (int)(_h_ + this.endtimestamp);
/* 1888 */       _h_ += this.state;
/* 1889 */       _h_ += this.teamid2teamstat.hashCode();
/* 1890 */       _h_ += this.teamid2isallright.hashCode();
/* 1891 */       _h_ += this.roleid2israndom.hashCode();
/* 1892 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1898 */       StringBuilder _sb_ = new StringBuilder();
/* 1899 */       _sb_.append("(");
/* 1900 */       _sb_.append(this.matchbegintimestamp);
/* 1901 */       _sb_.append(",");
/* 1902 */       _sb_.append(this.activityid);
/* 1903 */       _sb_.append(",");
/* 1904 */       _sb_.append(this.raceid);
/* 1905 */       _sb_.append(",");
/* 1906 */       _sb_.append(this.phaseno);
/* 1907 */       _sb_.append(",");
/* 1908 */       _sb_.append(this.roundno);
/* 1909 */       _sb_.append(",");
/* 1910 */       _sb_.append(this.timesno);
/* 1911 */       _sb_.append(",");
/* 1912 */       _sb_.append(this.commandlist);
/* 1913 */       _sb_.append(",");
/* 1914 */       _sb_.append(this.endtimestamp);
/* 1915 */       _sb_.append(",");
/* 1916 */       _sb_.append(this.state);
/* 1917 */       _sb_.append(",");
/* 1918 */       _sb_.append(this.teamid2teamstat);
/* 1919 */       _sb_.append(",");
/* 1920 */       _sb_.append(this.teamid2isallright);
/* 1921 */       _sb_.append(",");
/* 1922 */       _sb_.append(this.roleid2israndom);
/* 1923 */       _sb_.append(")");
/* 1924 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LonngBoatRaceMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */