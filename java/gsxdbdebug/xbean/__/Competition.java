/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.CompetitionMatch;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class Competition extends XBean implements xbean.Competition
/*      */ {
/*      */   private HashMap<CompetitionMatch, Integer> match2times;
/*      */   private int matchtimes;
/*      */   private HashMap<CompetitionMatch, xbean.CompetitionAgainst> againsts;
/*      */   private HashMap<Long, xbean.MissTurn> miss_turns;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.match2times.clear();
/*   25 */     this.matchtimes = 0;
/*   26 */     this.againsts.clear();
/*   27 */     this.miss_turns.clear();
/*      */   }
/*      */   
/*      */   Competition(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.match2times = new HashMap();
/*   34 */     this.matchtimes = 0;
/*   35 */     this.againsts = new HashMap();
/*   36 */     this.miss_turns = new HashMap();
/*      */   }
/*      */   
/*      */   public Competition()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Competition(Competition _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Competition(xbean.Competition _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof Competition)) { assign((Competition)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Competition _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.match2times = new HashMap();
/*   62 */     for (Map.Entry<CompetitionMatch, Integer> _e_ : _o_.match2times.entrySet())
/*   63 */       this.match2times.put(_e_.getKey(), _e_.getValue());
/*   64 */     this.matchtimes = _o_.matchtimes;
/*   65 */     this.againsts = new HashMap();
/*   66 */     for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : _o_.againsts.entrySet())
/*   67 */       this.againsts.put(_e_.getKey(), new CompetitionAgainst((xbean.CompetitionAgainst)_e_.getValue(), this, "againsts"));
/*   68 */     this.miss_turns = new HashMap();
/*   69 */     for (Map.Entry<Long, xbean.MissTurn> _e_ : _o_.miss_turns.entrySet()) {
/*   70 */       this.miss_turns.put(_e_.getKey(), new MissTurn((xbean.MissTurn)_e_.getValue(), this, "miss_turns"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   75 */     this.match2times = new HashMap();
/*   76 */     for (Map.Entry<CompetitionMatch, Integer> _e_ : _o_.match2times.entrySet())
/*   77 */       this.match2times.put(_e_.getKey(), _e_.getValue());
/*   78 */     this.matchtimes = _o_.matchtimes;
/*   79 */     this.againsts = new HashMap();
/*   80 */     for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : _o_.againsts.entrySet())
/*   81 */       this.againsts.put(_e_.getKey(), new CompetitionAgainst((xbean.CompetitionAgainst)_e_.getValue(), this, "againsts"));
/*   82 */     this.miss_turns = new HashMap();
/*   83 */     for (Map.Entry<Long, xbean.MissTurn> _e_ : _o_.miss_turns.entrySet()) {
/*   84 */       this.miss_turns.put(_e_.getKey(), new MissTurn((xbean.MissTurn)_e_.getValue(), this, "miss_turns"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.compact_uint32(this.match2times.size());
/*   92 */     for (Map.Entry<CompetitionMatch, Integer> _e_ : this.match2times.entrySet())
/*      */     {
/*   94 */       ((CompetitionMatch)_e_.getKey()).marshal(_os_);
/*   95 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   97 */     _os_.marshal(this.matchtimes);
/*   98 */     _os_.compact_uint32(this.againsts.size());
/*   99 */     for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : this.againsts.entrySet())
/*      */     {
/*  101 */       ((CompetitionMatch)_e_.getKey()).marshal(_os_);
/*  102 */       ((xbean.CompetitionAgainst)_e_.getValue()).marshal(_os_);
/*      */     }
/*  104 */     _os_.compact_uint32(this.miss_turns.size());
/*  105 */     for (Map.Entry<Long, xbean.MissTurn> _e_ : this.miss_turns.entrySet())
/*      */     {
/*  107 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  108 */       ((xbean.MissTurn)_e_.getValue()).marshal(_os_);
/*      */     }
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*      */     
/*  118 */     int size = _os_.uncompact_uint32();
/*  119 */     if (size >= 12)
/*      */     {
/*  121 */       this.match2times = new HashMap(size * 2);
/*      */     }
/*  123 */     for (; size > 0; size--)
/*      */     {
/*  125 */       CompetitionMatch _k_ = new CompetitionMatch();
/*  126 */       _k_.unmarshal(_os_);
/*  127 */       int _v_ = 0;
/*  128 */       _v_ = _os_.unmarshal_int();
/*  129 */       this.match2times.put(_k_, Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  132 */     this.matchtimes = _os_.unmarshal_int();
/*      */     
/*  134 */     int size = _os_.uncompact_uint32();
/*  135 */     if (size >= 12)
/*      */     {
/*  137 */       this.againsts = new HashMap(size * 2);
/*      */     }
/*  139 */     for (; size > 0; size--)
/*      */     {
/*  141 */       CompetitionMatch _k_ = new CompetitionMatch();
/*  142 */       _k_.unmarshal(_os_);
/*  143 */       xbean.CompetitionAgainst _v_ = new CompetitionAgainst(0, this, "againsts");
/*  144 */       _v_.unmarshal(_os_);
/*  145 */       this.againsts.put(_k_, _v_);
/*      */     }
/*      */     
/*      */ 
/*  149 */     int size = _os_.uncompact_uint32();
/*  150 */     if (size >= 12)
/*      */     {
/*  152 */       this.miss_turns = new HashMap(size * 2);
/*      */     }
/*  154 */     for (; size > 0; size--)
/*      */     {
/*  156 */       long _k_ = 0L;
/*  157 */       _k_ = _os_.unmarshal_long();
/*  158 */       xbean.MissTurn _v_ = new MissTurn(0, this, "miss_turns");
/*  159 */       _v_.unmarshal(_os_);
/*  160 */       this.miss_turns.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  163 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  169 */     _xdb_verify_unsafe_();
/*  170 */     int _size_ = 0;
/*  171 */     for (Map.Entry<CompetitionMatch, Integer> _e_ : this.match2times.entrySet())
/*      */     {
/*  173 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getKey());
/*  174 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  176 */     _size_ += CodedOutputStream.computeInt32Size(2, this.matchtimes);
/*  177 */     for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : this.againsts.entrySet())
/*      */     {
/*  179 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getKey());
/*  180 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */     }
/*  182 */     for (Map.Entry<Long, xbean.MissTurn> _e_ : this.miss_turns.entrySet())
/*      */     {
/*  184 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  185 */       _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */     }
/*  187 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  193 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  196 */       for (Map.Entry<CompetitionMatch, Integer> _e_ : this.match2times.entrySet())
/*      */       {
/*  198 */         _output_.writeMessage(1, (Message)_e_.getKey());
/*  199 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  201 */       _output_.writeInt32(2, this.matchtimes);
/*  202 */       for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : this.againsts.entrySet())
/*      */       {
/*  204 */         _output_.writeMessage(3, (Message)_e_.getKey());
/*  205 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*      */       }
/*  207 */       for (Map.Entry<Long, xbean.MissTurn> _e_ : this.miss_turns.entrySet())
/*      */       {
/*  209 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  210 */         _output_.writeMessage(4, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  215 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  217 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  223 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  226 */       boolean done = false;
/*  227 */       while (!done)
/*      */       {
/*  229 */         int tag = _input_.readTag();
/*  230 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  234 */           done = true;
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  239 */           CompetitionMatch _k_ = new CompetitionMatch();
/*  240 */           _input_.readMessage(_k_);
/*  241 */           int readTag = _input_.readTag();
/*  242 */           if (8 != readTag)
/*      */           {
/*  244 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  246 */           int _v_ = 0;
/*  247 */           _v_ = _input_.readInt32();
/*  248 */           this.match2times.put(_k_, Integer.valueOf(_v_));
/*  249 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  253 */           this.matchtimes = _input_.readInt32();
/*  254 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  258 */           CompetitionMatch _k_ = new CompetitionMatch();
/*  259 */           _input_.readMessage(_k_);
/*  260 */           int readTag = _input_.readTag();
/*  261 */           if (26 != readTag)
/*      */           {
/*  263 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  265 */           xbean.CompetitionAgainst _v_ = new CompetitionAgainst(0, this, "againsts");
/*  266 */           _input_.readMessage(_v_);
/*  267 */           this.againsts.put(_k_, _v_);
/*  268 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  272 */           long _k_ = 0L;
/*  273 */           _k_ = _input_.readInt64();
/*  274 */           int readTag = _input_.readTag();
/*  275 */           if (34 != readTag)
/*      */           {
/*  277 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  279 */           xbean.MissTurn _v_ = new MissTurn(0, this, "miss_turns");
/*  280 */           _input_.readMessage(_v_);
/*  281 */           this.miss_turns.put(Long.valueOf(_k_), _v_);
/*  282 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  286 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  288 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  297 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  301 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  303 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Competition copy()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return new Competition(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Competition toData()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Competition toBean()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return new Competition(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Competition toDataIf()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Competition toBeanIf()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<CompetitionMatch, Integer> getMatch2times()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return xdb.Logs.logMap(new xdb.LogKey(this, "match2times"), this.match2times);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<CompetitionMatch, Integer> getMatch2timesAsData()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*      */     
/*  360 */     Competition _o_ = this;
/*  361 */     Map<CompetitionMatch, Integer> match2times = new HashMap();
/*  362 */     for (Map.Entry<CompetitionMatch, Integer> _e_ : _o_.match2times.entrySet())
/*  363 */       match2times.put(_e_.getKey(), _e_.getValue());
/*  364 */     return match2times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMatchtimes()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return this.matchtimes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<CompetitionMatch, xbean.CompetitionAgainst> getAgainsts()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     return xdb.Logs.logMap(new xdb.LogKey(this, "againsts"), this.againsts);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<CompetitionMatch, xbean.CompetitionAgainst> getAgainstsAsData()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*      */     
/*  389 */     Competition _o_ = this;
/*  390 */     Map<CompetitionMatch, xbean.CompetitionAgainst> againsts = new HashMap();
/*  391 */     for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : _o_.againsts.entrySet())
/*  392 */       againsts.put(_e_.getKey(), new CompetitionAgainst.Data((xbean.CompetitionAgainst)_e_.getValue()));
/*  393 */     return againsts;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MissTurn> getMiss_turns()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     return xdb.Logs.logMap(new xdb.LogKey(this, "miss_turns"), this.miss_turns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MissTurn> getMiss_turnsAsData()
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*      */     
/*  410 */     Competition _o_ = this;
/*  411 */     Map<Long, xbean.MissTurn> miss_turns = new HashMap();
/*  412 */     for (Map.Entry<Long, xbean.MissTurn> _e_ : _o_.miss_turns.entrySet())
/*  413 */       miss_turns.put(_e_.getKey(), new MissTurn.Data((xbean.MissTurn)_e_.getValue()));
/*  414 */     return miss_turns;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMatchtimes(int _v_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     xdb.Logs.logIf(new xdb.LogKey(this, "matchtimes")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  426 */         new xdb.logs.LogInt(this, Competition.this.matchtimes)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  430 */             Competition.this.matchtimes = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  434 */     });
/*  435 */     this.matchtimes = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     Competition _o_ = null;
/*  443 */     if ((_o1_ instanceof Competition)) { _o_ = (Competition)_o1_;
/*  444 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  445 */       return false;
/*  446 */     if (!this.match2times.equals(_o_.match2times)) return false;
/*  447 */     if (this.matchtimes != _o_.matchtimes) return false;
/*  448 */     if (!this.againsts.equals(_o_.againsts)) return false;
/*  449 */     if (!this.miss_turns.equals(_o_.miss_turns)) return false;
/*  450 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     int _h_ = 0;
/*  458 */     _h_ += this.match2times.hashCode();
/*  459 */     _h_ += this.matchtimes;
/*  460 */     _h_ += this.againsts.hashCode();
/*  461 */     _h_ += this.miss_turns.hashCode();
/*  462 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  468 */     _xdb_verify_unsafe_();
/*  469 */     StringBuilder _sb_ = new StringBuilder();
/*  470 */     _sb_.append("(");
/*  471 */     _sb_.append(this.match2times);
/*  472 */     _sb_.append(",");
/*  473 */     _sb_.append(this.matchtimes);
/*  474 */     _sb_.append(",");
/*  475 */     _sb_.append(this.againsts);
/*  476 */     _sb_.append(",");
/*  477 */     _sb_.append(this.miss_turns);
/*  478 */     _sb_.append(")");
/*  479 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  485 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  486 */     lb.add(new xdb.logs.ListenableMap().setVarName("match2times"));
/*  487 */     lb.add(new xdb.logs.ListenableChanged().setVarName("matchtimes"));
/*  488 */     lb.add(new xdb.logs.ListenableMap().setVarName("againsts"));
/*  489 */     lb.add(new xdb.logs.ListenableMap().setVarName("miss_turns"));
/*  490 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Competition {
/*      */     private Const() {}
/*      */     
/*      */     Competition nThis() {
/*  497 */       return Competition.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  503 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Competition copy()
/*      */     {
/*  509 */       return Competition.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Competition toData()
/*      */     {
/*  515 */       return Competition.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Competition toBean()
/*      */     {
/*  520 */       return Competition.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Competition toDataIf()
/*      */     {
/*  526 */       return Competition.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Competition toBeanIf()
/*      */     {
/*  531 */       return Competition.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CompetitionMatch, Integer> getMatch2times()
/*      */     {
/*  538 */       Competition.this._xdb_verify_unsafe_();
/*  539 */       return xdb.Consts.constMap(Competition.this.match2times);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CompetitionMatch, Integer> getMatch2timesAsData()
/*      */     {
/*  546 */       Competition.this._xdb_verify_unsafe_();
/*      */       
/*  548 */       Competition _o_ = Competition.this;
/*  549 */       Map<CompetitionMatch, Integer> match2times = new HashMap();
/*  550 */       for (Map.Entry<CompetitionMatch, Integer> _e_ : _o_.match2times.entrySet())
/*  551 */         match2times.put(_e_.getKey(), _e_.getValue());
/*  552 */       return match2times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMatchtimes()
/*      */     {
/*  559 */       Competition.this._xdb_verify_unsafe_();
/*  560 */       return Competition.this.matchtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CompetitionMatch, xbean.CompetitionAgainst> getAgainsts()
/*      */     {
/*  567 */       Competition.this._xdb_verify_unsafe_();
/*  568 */       return xdb.Consts.constMap(Competition.this.againsts);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CompetitionMatch, xbean.CompetitionAgainst> getAgainstsAsData()
/*      */     {
/*  575 */       Competition.this._xdb_verify_unsafe_();
/*      */       
/*  577 */       Competition _o_ = Competition.this;
/*  578 */       Map<CompetitionMatch, xbean.CompetitionAgainst> againsts = new HashMap();
/*  579 */       for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : _o_.againsts.entrySet())
/*  580 */         againsts.put(_e_.getKey(), new CompetitionAgainst.Data((xbean.CompetitionAgainst)_e_.getValue()));
/*  581 */       return againsts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MissTurn> getMiss_turns()
/*      */     {
/*  588 */       Competition.this._xdb_verify_unsafe_();
/*  589 */       return xdb.Consts.constMap(Competition.this.miss_turns);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MissTurn> getMiss_turnsAsData()
/*      */     {
/*  596 */       Competition.this._xdb_verify_unsafe_();
/*      */       
/*  598 */       Competition _o_ = Competition.this;
/*  599 */       Map<Long, xbean.MissTurn> miss_turns = new HashMap();
/*  600 */       for (Map.Entry<Long, xbean.MissTurn> _e_ : _o_.miss_turns.entrySet())
/*  601 */         miss_turns.put(_e_.getKey(), new MissTurn.Data((xbean.MissTurn)_e_.getValue()));
/*  602 */       return miss_turns;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMatchtimes(int _v_)
/*      */     {
/*  609 */       Competition.this._xdb_verify_unsafe_();
/*  610 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  616 */       Competition.this._xdb_verify_unsafe_();
/*  617 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  623 */       Competition.this._xdb_verify_unsafe_();
/*  624 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  630 */       return Competition.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  636 */       return Competition.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  642 */       Competition.this._xdb_verify_unsafe_();
/*  643 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  649 */       return Competition.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  655 */       return Competition.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  661 */       Competition.this._xdb_verify_unsafe_();
/*  662 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  668 */       return Competition.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  674 */       return Competition.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  680 */       return Competition.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  686 */       return Competition.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  692 */       return Competition.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  698 */       return Competition.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  704 */       return Competition.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Competition
/*      */   {
/*      */     private HashMap<CompetitionMatch, Integer> match2times;
/*      */     
/*      */     private int matchtimes;
/*      */     
/*      */     private HashMap<CompetitionMatch, xbean.CompetitionAgainst> againsts;
/*      */     
/*      */     private HashMap<Long, xbean.MissTurn> miss_turns;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  722 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  727 */       this.match2times = new HashMap();
/*  728 */       this.matchtimes = 0;
/*  729 */       this.againsts = new HashMap();
/*  730 */       this.miss_turns = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.Competition _o1_)
/*      */     {
/*  735 */       if ((_o1_ instanceof Competition)) { assign((Competition)_o1_);
/*  736 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  737 */       } else if ((_o1_ instanceof Competition.Const)) assign(((Competition.Const)_o1_).nThis()); else {
/*  738 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Competition _o_) {
/*  743 */       this.match2times = new HashMap();
/*  744 */       for (Map.Entry<CompetitionMatch, Integer> _e_ : _o_.match2times.entrySet())
/*  745 */         this.match2times.put(_e_.getKey(), _e_.getValue());
/*  746 */       this.matchtimes = _o_.matchtimes;
/*  747 */       this.againsts = new HashMap();
/*  748 */       for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : _o_.againsts.entrySet())
/*  749 */         this.againsts.put(_e_.getKey(), new CompetitionAgainst.Data((xbean.CompetitionAgainst)_e_.getValue()));
/*  750 */       this.miss_turns = new HashMap();
/*  751 */       for (Map.Entry<Long, xbean.MissTurn> _e_ : _o_.miss_turns.entrySet()) {
/*  752 */         this.miss_turns.put(_e_.getKey(), new MissTurn.Data((xbean.MissTurn)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  757 */       this.match2times = new HashMap();
/*  758 */       for (Map.Entry<CompetitionMatch, Integer> _e_ : _o_.match2times.entrySet())
/*  759 */         this.match2times.put(_e_.getKey(), _e_.getValue());
/*  760 */       this.matchtimes = _o_.matchtimes;
/*  761 */       this.againsts = new HashMap();
/*  762 */       for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : _o_.againsts.entrySet())
/*  763 */         this.againsts.put(_e_.getKey(), new CompetitionAgainst.Data((xbean.CompetitionAgainst)_e_.getValue()));
/*  764 */       this.miss_turns = new HashMap();
/*  765 */       for (Map.Entry<Long, xbean.MissTurn> _e_ : _o_.miss_turns.entrySet()) {
/*  766 */         this.miss_turns.put(_e_.getKey(), new MissTurn.Data((xbean.MissTurn)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  772 */       _os_.compact_uint32(this.match2times.size());
/*  773 */       for (Map.Entry<CompetitionMatch, Integer> _e_ : this.match2times.entrySet())
/*      */       {
/*  775 */         ((CompetitionMatch)_e_.getKey()).marshal(_os_);
/*  776 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  778 */       _os_.marshal(this.matchtimes);
/*  779 */       _os_.compact_uint32(this.againsts.size());
/*  780 */       for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : this.againsts.entrySet())
/*      */       {
/*  782 */         ((CompetitionMatch)_e_.getKey()).marshal(_os_);
/*  783 */         ((xbean.CompetitionAgainst)_e_.getValue()).marshal(_os_);
/*      */       }
/*  785 */       _os_.compact_uint32(this.miss_turns.size());
/*  786 */       for (Map.Entry<Long, xbean.MissTurn> _e_ : this.miss_turns.entrySet())
/*      */       {
/*  788 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  789 */         ((xbean.MissTurn)_e_.getValue()).marshal(_os_);
/*      */       }
/*  791 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  798 */       int size = _os_.uncompact_uint32();
/*  799 */       if (size >= 12)
/*      */       {
/*  801 */         this.match2times = new HashMap(size * 2);
/*      */       }
/*  803 */       for (; size > 0; size--)
/*      */       {
/*  805 */         CompetitionMatch _k_ = new CompetitionMatch();
/*  806 */         _k_.unmarshal(_os_);
/*  807 */         int _v_ = 0;
/*  808 */         _v_ = _os_.unmarshal_int();
/*  809 */         this.match2times.put(_k_, Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  812 */       this.matchtimes = _os_.unmarshal_int();
/*      */       
/*  814 */       int size = _os_.uncompact_uint32();
/*  815 */       if (size >= 12)
/*      */       {
/*  817 */         this.againsts = new HashMap(size * 2);
/*      */       }
/*  819 */       for (; size > 0; size--)
/*      */       {
/*  821 */         CompetitionMatch _k_ = new CompetitionMatch();
/*  822 */         _k_.unmarshal(_os_);
/*  823 */         xbean.CompetitionAgainst _v_ = xbean.Pod.newCompetitionAgainstData();
/*  824 */         _v_.unmarshal(_os_);
/*  825 */         this.againsts.put(_k_, _v_);
/*      */       }
/*      */       
/*      */ 
/*  829 */       int size = _os_.uncompact_uint32();
/*  830 */       if (size >= 12)
/*      */       {
/*  832 */         this.miss_turns = new HashMap(size * 2);
/*      */       }
/*  834 */       for (; size > 0; size--)
/*      */       {
/*  836 */         long _k_ = 0L;
/*  837 */         _k_ = _os_.unmarshal_long();
/*  838 */         xbean.MissTurn _v_ = xbean.Pod.newMissTurnData();
/*  839 */         _v_.unmarshal(_os_);
/*  840 */         this.miss_turns.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  843 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  849 */       int _size_ = 0;
/*  850 */       for (Map.Entry<CompetitionMatch, Integer> _e_ : this.match2times.entrySet())
/*      */       {
/*  852 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getKey());
/*  853 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  855 */       _size_ += CodedOutputStream.computeInt32Size(2, this.matchtimes);
/*  856 */       for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : this.againsts.entrySet())
/*      */       {
/*  858 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getKey());
/*  859 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */       }
/*  861 */       for (Map.Entry<Long, xbean.MissTurn> _e_ : this.miss_turns.entrySet())
/*      */       {
/*  863 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  864 */         _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */       }
/*  866 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  874 */         for (Map.Entry<CompetitionMatch, Integer> _e_ : this.match2times.entrySet())
/*      */         {
/*  876 */           _output_.writeMessage(1, (Message)_e_.getKey());
/*  877 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  879 */         _output_.writeInt32(2, this.matchtimes);
/*  880 */         for (Map.Entry<CompetitionMatch, xbean.CompetitionAgainst> _e_ : this.againsts.entrySet())
/*      */         {
/*  882 */           _output_.writeMessage(3, (Message)_e_.getKey());
/*  883 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*      */         }
/*  885 */         for (Map.Entry<Long, xbean.MissTurn> _e_ : this.miss_turns.entrySet())
/*      */         {
/*  887 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  888 */           _output_.writeMessage(4, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  893 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  895 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  903 */         boolean done = false;
/*  904 */         while (!done)
/*      */         {
/*  906 */           int tag = _input_.readTag();
/*  907 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  911 */             done = true;
/*  912 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  916 */             CompetitionMatch _k_ = new CompetitionMatch();
/*  917 */             _input_.readMessage(_k_);
/*  918 */             int readTag = _input_.readTag();
/*  919 */             if (8 != readTag)
/*      */             {
/*  921 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  923 */             int _v_ = 0;
/*  924 */             _v_ = _input_.readInt32();
/*  925 */             this.match2times.put(_k_, Integer.valueOf(_v_));
/*  926 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  930 */             this.matchtimes = _input_.readInt32();
/*  931 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  935 */             CompetitionMatch _k_ = new CompetitionMatch();
/*  936 */             _input_.readMessage(_k_);
/*  937 */             int readTag = _input_.readTag();
/*  938 */             if (26 != readTag)
/*      */             {
/*  940 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  942 */             xbean.CompetitionAgainst _v_ = xbean.Pod.newCompetitionAgainstData();
/*  943 */             _input_.readMessage(_v_);
/*  944 */             this.againsts.put(_k_, _v_);
/*  945 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  949 */             long _k_ = 0L;
/*  950 */             _k_ = _input_.readInt64();
/*  951 */             int readTag = _input_.readTag();
/*  952 */             if (34 != readTag)
/*      */             {
/*  954 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  956 */             xbean.MissTurn _v_ = xbean.Pod.newMissTurnData();
/*  957 */             _input_.readMessage(_v_);
/*  958 */             this.miss_turns.put(Long.valueOf(_k_), _v_);
/*  959 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  963 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  965 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  974 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  978 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  980 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Competition copy()
/*      */     {
/*  986 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Competition toData()
/*      */     {
/*  992 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Competition toBean()
/*      */     {
/*  997 */       return new Competition(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Competition toDataIf()
/*      */     {
/* 1003 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Competition toBeanIf()
/*      */     {
/* 1008 */       return new Competition(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1014 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1018 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1022 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1026 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1030 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1034 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1038 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CompetitionMatch, Integer> getMatch2times()
/*      */     {
/* 1045 */       return this.match2times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CompetitionMatch, Integer> getMatch2timesAsData()
/*      */     {
/* 1052 */       return this.match2times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMatchtimes()
/*      */     {
/* 1059 */       return this.matchtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CompetitionMatch, xbean.CompetitionAgainst> getAgainsts()
/*      */     {
/* 1066 */       return this.againsts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CompetitionMatch, xbean.CompetitionAgainst> getAgainstsAsData()
/*      */     {
/* 1073 */       return this.againsts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MissTurn> getMiss_turns()
/*      */     {
/* 1080 */       return this.miss_turns;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MissTurn> getMiss_turnsAsData()
/*      */     {
/* 1087 */       return this.miss_turns;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMatchtimes(int _v_)
/*      */     {
/* 1094 */       this.matchtimes = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1100 */       if (!(_o1_ instanceof Data)) return false;
/* 1101 */       Data _o_ = (Data)_o1_;
/* 1102 */       if (!this.match2times.equals(_o_.match2times)) return false;
/* 1103 */       if (this.matchtimes != _o_.matchtimes) return false;
/* 1104 */       if (!this.againsts.equals(_o_.againsts)) return false;
/* 1105 */       if (!this.miss_turns.equals(_o_.miss_turns)) return false;
/* 1106 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1112 */       int _h_ = 0;
/* 1113 */       _h_ += this.match2times.hashCode();
/* 1114 */       _h_ += this.matchtimes;
/* 1115 */       _h_ += this.againsts.hashCode();
/* 1116 */       _h_ += this.miss_turns.hashCode();
/* 1117 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1123 */       StringBuilder _sb_ = new StringBuilder();
/* 1124 */       _sb_.append("(");
/* 1125 */       _sb_.append(this.match2times);
/* 1126 */       _sb_.append(",");
/* 1127 */       _sb_.append(this.matchtimes);
/* 1128 */       _sb_.append(",");
/* 1129 */       _sb_.append(this.againsts);
/* 1130 */       _sb_.append(",");
/* 1131 */       _sb_.append(this.miss_turns);
/* 1132 */       _sb_.append(")");
/* 1133 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Competition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */