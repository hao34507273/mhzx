/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class JingjiPvp
/*      */   extends XBean
/*      */   implements xbean.JingjiPvp
/*      */ {
/*      */   private int jifen;
/*      */   private int buycount;
/*      */   private int buychallengecount;
/*      */   private int challengecount;
/*      */   private int winpoint;
/*      */   private int firstvictoryrewardid;
/*      */   private int fivefightrewardid;
/*      */   private int fightcount;
/*      */   private int victorycount;
/*      */   private boolean issendbulletin;
/*      */   private int lastseasonphase;
/*      */   private int lastseasonrank;
/*      */   private long lastseasonendtime;
/*      */   private int reservedexp;
/*      */   private long inittime;
/*      */   private int merge_cleared;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   48 */     this.jifen = 0;
/*   49 */     this.buycount = 0;
/*   50 */     this.buychallengecount = 0;
/*   51 */     this.challengecount = 0;
/*   52 */     this.winpoint = 0;
/*   53 */     this.firstvictoryrewardid = -1;
/*   54 */     this.fivefightrewardid = -1;
/*   55 */     this.fightcount = 0;
/*   56 */     this.victorycount = 0;
/*   57 */     this.issendbulletin = false;
/*   58 */     this.lastseasonphase = 0;
/*   59 */     this.lastseasonrank = 0;
/*   60 */     this.lastseasonendtime = 0L;
/*   61 */     this.reservedexp = 0;
/*   62 */     this.inittime = 0L;
/*   63 */     this.merge_cleared = 0;
/*      */   }
/*      */   
/*      */   JingjiPvp(int __, XBean _xp_, String _vn_)
/*      */   {
/*   68 */     super(_xp_, _vn_);
/*   69 */     this.jifen = 0;
/*   70 */     this.buycount = 0;
/*   71 */     this.buychallengecount = 0;
/*   72 */     this.challengecount = 0;
/*   73 */     this.winpoint = 0;
/*   74 */     this.firstvictoryrewardid = -1;
/*   75 */     this.fivefightrewardid = -1;
/*   76 */     this.fightcount = 0;
/*   77 */     this.victorycount = 0;
/*   78 */     this.issendbulletin = false;
/*   79 */     this.lastseasonphase = 0;
/*   80 */     this.lastseasonrank = 0;
/*   81 */     this.lastseasonendtime = 0L;
/*   82 */     this.reservedexp = 0;
/*   83 */     this.inittime = 0L;
/*   84 */     this.merge_cleared = 0;
/*      */   }
/*      */   
/*      */   public JingjiPvp()
/*      */   {
/*   89 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public JingjiPvp(JingjiPvp _o_)
/*      */   {
/*   94 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   JingjiPvp(xbean.JingjiPvp _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   99 */     super(_xp_, _vn_);
/*  100 */     if ((_o1_ instanceof JingjiPvp)) { assign((JingjiPvp)_o1_);
/*  101 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  102 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  103 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(JingjiPvp _o_) {
/*  108 */     _o_._xdb_verify_unsafe_();
/*  109 */     this.jifen = _o_.jifen;
/*  110 */     this.buycount = _o_.buycount;
/*  111 */     this.buychallengecount = _o_.buychallengecount;
/*  112 */     this.challengecount = _o_.challengecount;
/*  113 */     this.winpoint = _o_.winpoint;
/*  114 */     this.firstvictoryrewardid = _o_.firstvictoryrewardid;
/*  115 */     this.fivefightrewardid = _o_.fivefightrewardid;
/*  116 */     this.fightcount = _o_.fightcount;
/*  117 */     this.victorycount = _o_.victorycount;
/*  118 */     this.issendbulletin = _o_.issendbulletin;
/*  119 */     this.lastseasonphase = _o_.lastseasonphase;
/*  120 */     this.lastseasonrank = _o_.lastseasonrank;
/*  121 */     this.lastseasonendtime = _o_.lastseasonendtime;
/*  122 */     this.reservedexp = _o_.reservedexp;
/*  123 */     this.inittime = _o_.inittime;
/*  124 */     this.merge_cleared = _o_.merge_cleared;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  129 */     this.jifen = _o_.jifen;
/*  130 */     this.buycount = _o_.buycount;
/*  131 */     this.buychallengecount = _o_.buychallengecount;
/*  132 */     this.challengecount = _o_.challengecount;
/*  133 */     this.winpoint = _o_.winpoint;
/*  134 */     this.firstvictoryrewardid = _o_.firstvictoryrewardid;
/*  135 */     this.fivefightrewardid = _o_.fivefightrewardid;
/*  136 */     this.fightcount = _o_.fightcount;
/*  137 */     this.victorycount = _o_.victorycount;
/*  138 */     this.issendbulletin = _o_.issendbulletin;
/*  139 */     this.lastseasonphase = _o_.lastseasonphase;
/*  140 */     this.lastseasonrank = _o_.lastseasonrank;
/*  141 */     this.lastseasonendtime = _o_.lastseasonendtime;
/*  142 */     this.reservedexp = _o_.reservedexp;
/*  143 */     this.inittime = _o_.inittime;
/*  144 */     this.merge_cleared = _o_.merge_cleared;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  150 */     _xdb_verify_unsafe_();
/*  151 */     _os_.marshal(this.jifen);
/*  152 */     _os_.marshal(this.buycount);
/*  153 */     _os_.marshal(this.buychallengecount);
/*  154 */     _os_.marshal(this.challengecount);
/*  155 */     _os_.marshal(this.winpoint);
/*  156 */     _os_.marshal(this.firstvictoryrewardid);
/*  157 */     _os_.marshal(this.fivefightrewardid);
/*  158 */     _os_.marshal(this.fightcount);
/*  159 */     _os_.marshal(this.victorycount);
/*  160 */     _os_.marshal(this.issendbulletin);
/*  161 */     _os_.marshal(this.lastseasonphase);
/*  162 */     _os_.marshal(this.lastseasonrank);
/*  163 */     _os_.marshal(this.lastseasonendtime);
/*  164 */     _os_.marshal(this.reservedexp);
/*  165 */     _os_.marshal(this.inittime);
/*  166 */     _os_.marshal(this.merge_cleared);
/*  167 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  173 */     _xdb_verify_unsafe_();
/*  174 */     this.jifen = _os_.unmarshal_int();
/*  175 */     this.buycount = _os_.unmarshal_int();
/*  176 */     this.buychallengecount = _os_.unmarshal_int();
/*  177 */     this.challengecount = _os_.unmarshal_int();
/*  178 */     this.winpoint = _os_.unmarshal_int();
/*  179 */     this.firstvictoryrewardid = _os_.unmarshal_int();
/*  180 */     this.fivefightrewardid = _os_.unmarshal_int();
/*  181 */     this.fightcount = _os_.unmarshal_int();
/*  182 */     this.victorycount = _os_.unmarshal_int();
/*  183 */     this.issendbulletin = _os_.unmarshal_boolean();
/*  184 */     this.lastseasonphase = _os_.unmarshal_int();
/*  185 */     this.lastseasonrank = _os_.unmarshal_int();
/*  186 */     this.lastseasonendtime = _os_.unmarshal_long();
/*  187 */     this.reservedexp = _os_.unmarshal_int();
/*  188 */     this.inittime = _os_.unmarshal_long();
/*  189 */     this.merge_cleared = _os_.unmarshal_int();
/*  190 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  196 */     _xdb_verify_unsafe_();
/*  197 */     int _size_ = 0;
/*  198 */     _size_ += CodedOutputStream.computeInt32Size(1, this.jifen);
/*  199 */     _size_ += CodedOutputStream.computeInt32Size(2, this.buycount);
/*  200 */     _size_ += CodedOutputStream.computeInt32Size(3, this.buychallengecount);
/*  201 */     _size_ += CodedOutputStream.computeInt32Size(4, this.challengecount);
/*  202 */     _size_ += CodedOutputStream.computeInt32Size(5, this.winpoint);
/*  203 */     _size_ += CodedOutputStream.computeInt32Size(6, this.firstvictoryrewardid);
/*  204 */     _size_ += CodedOutputStream.computeInt32Size(7, this.fivefightrewardid);
/*  205 */     _size_ += CodedOutputStream.computeInt32Size(8, this.fightcount);
/*  206 */     _size_ += CodedOutputStream.computeInt32Size(9, this.victorycount);
/*  207 */     _size_ += CodedOutputStream.computeBoolSize(10, this.issendbulletin);
/*  208 */     _size_ += CodedOutputStream.computeInt32Size(11, this.lastseasonphase);
/*  209 */     _size_ += CodedOutputStream.computeInt32Size(12, this.lastseasonrank);
/*  210 */     _size_ += CodedOutputStream.computeInt64Size(13, this.lastseasonendtime);
/*  211 */     _size_ += CodedOutputStream.computeInt32Size(14, this.reservedexp);
/*  212 */     _size_ += CodedOutputStream.computeInt64Size(15, this.inittime);
/*  213 */     _size_ += CodedOutputStream.computeInt32Size(16, this.merge_cleared);
/*  214 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  220 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  223 */       _output_.writeInt32(1, this.jifen);
/*  224 */       _output_.writeInt32(2, this.buycount);
/*  225 */       _output_.writeInt32(3, this.buychallengecount);
/*  226 */       _output_.writeInt32(4, this.challengecount);
/*  227 */       _output_.writeInt32(5, this.winpoint);
/*  228 */       _output_.writeInt32(6, this.firstvictoryrewardid);
/*  229 */       _output_.writeInt32(7, this.fivefightrewardid);
/*  230 */       _output_.writeInt32(8, this.fightcount);
/*  231 */       _output_.writeInt32(9, this.victorycount);
/*  232 */       _output_.writeBool(10, this.issendbulletin);
/*  233 */       _output_.writeInt32(11, this.lastseasonphase);
/*  234 */       _output_.writeInt32(12, this.lastseasonrank);
/*  235 */       _output_.writeInt64(13, this.lastseasonendtime);
/*  236 */       _output_.writeInt32(14, this.reservedexp);
/*  237 */       _output_.writeInt64(15, this.inittime);
/*  238 */       _output_.writeInt32(16, this.merge_cleared);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  242 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  244 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  250 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  253 */       boolean done = false;
/*  254 */       while (!done)
/*      */       {
/*  256 */         int tag = _input_.readTag();
/*  257 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  261 */           done = true;
/*  262 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  266 */           this.jifen = _input_.readInt32();
/*  267 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  271 */           this.buycount = _input_.readInt32();
/*  272 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  276 */           this.buychallengecount = _input_.readInt32();
/*  277 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  281 */           this.challengecount = _input_.readInt32();
/*  282 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  286 */           this.winpoint = _input_.readInt32();
/*  287 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  291 */           this.firstvictoryrewardid = _input_.readInt32();
/*  292 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  296 */           this.fivefightrewardid = _input_.readInt32();
/*  297 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  301 */           this.fightcount = _input_.readInt32();
/*  302 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  306 */           this.victorycount = _input_.readInt32();
/*  307 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  311 */           this.issendbulletin = _input_.readBool();
/*  312 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  316 */           this.lastseasonphase = _input_.readInt32();
/*  317 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  321 */           this.lastseasonrank = _input_.readInt32();
/*  322 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  326 */           this.lastseasonendtime = _input_.readInt64();
/*  327 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  331 */           this.reservedexp = _input_.readInt32();
/*  332 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  336 */           this.inittime = _input_.readInt64();
/*  337 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  341 */           this.merge_cleared = _input_.readInt32();
/*  342 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  346 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  348 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  357 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  361 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  363 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.JingjiPvp copy()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return new JingjiPvp(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.JingjiPvp toData()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.JingjiPvp toBean()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return new JingjiPvp(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.JingjiPvp toDataIf()
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.JingjiPvp toBeanIf()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  402 */     _xdb_verify_unsafe_();
/*  403 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getJifen()
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     return this.jifen;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBuycount()
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     return this.buycount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBuychallengecount()
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*  427 */     return this.buychallengecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChallengecount()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     return this.challengecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWinpoint()
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     return this.winpoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFirstvictoryrewardid()
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     return this.firstvictoryrewardid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFivefightrewardid()
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     return this.fivefightrewardid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFightcount()
/*      */   {
/*  466 */     _xdb_verify_unsafe_();
/*  467 */     return this.fightcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVictorycount()
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     return this.victorycount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIssendbulletin()
/*      */   {
/*  482 */     _xdb_verify_unsafe_();
/*  483 */     return this.issendbulletin;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLastseasonphase()
/*      */   {
/*  490 */     _xdb_verify_unsafe_();
/*  491 */     return this.lastseasonphase;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLastseasonrank()
/*      */   {
/*  498 */     _xdb_verify_unsafe_();
/*  499 */     return this.lastseasonrank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastseasonendtime()
/*      */   {
/*  506 */     _xdb_verify_unsafe_();
/*  507 */     return this.lastseasonendtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getReservedexp()
/*      */   {
/*  514 */     _xdb_verify_unsafe_();
/*  515 */     return this.reservedexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInittime()
/*      */   {
/*  522 */     _xdb_verify_unsafe_();
/*  523 */     return this.inittime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMerge_cleared()
/*      */   {
/*  530 */     _xdb_verify_unsafe_();
/*  531 */     return this.merge_cleared;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setJifen(int _v_)
/*      */   {
/*  538 */     _xdb_verify_unsafe_();
/*  539 */     Logs.logIf(new LogKey(this, "jifen")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  543 */         new LogInt(this, JingjiPvp.this.jifen)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  547 */             JingjiPvp.this.jifen = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  551 */     });
/*  552 */     this.jifen = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuycount(int _v_)
/*      */   {
/*  559 */     _xdb_verify_unsafe_();
/*  560 */     Logs.logIf(new LogKey(this, "buycount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  564 */         new LogInt(this, JingjiPvp.this.buycount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  568 */             JingjiPvp.this.buycount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  572 */     });
/*  573 */     this.buycount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuychallengecount(int _v_)
/*      */   {
/*  580 */     _xdb_verify_unsafe_();
/*  581 */     Logs.logIf(new LogKey(this, "buychallengecount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  585 */         new LogInt(this, JingjiPvp.this.buychallengecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  589 */             JingjiPvp.this.buychallengecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  593 */     });
/*  594 */     this.buychallengecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChallengecount(int _v_)
/*      */   {
/*  601 */     _xdb_verify_unsafe_();
/*  602 */     Logs.logIf(new LogKey(this, "challengecount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  606 */         new LogInt(this, JingjiPvp.this.challengecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  610 */             JingjiPvp.this.challengecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  614 */     });
/*  615 */     this.challengecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWinpoint(int _v_)
/*      */   {
/*  622 */     _xdb_verify_unsafe_();
/*  623 */     Logs.logIf(new LogKey(this, "winpoint")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  627 */         new LogInt(this, JingjiPvp.this.winpoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  631 */             JingjiPvp.this.winpoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  635 */     });
/*  636 */     this.winpoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFirstvictoryrewardid(int _v_)
/*      */   {
/*  643 */     _xdb_verify_unsafe_();
/*  644 */     Logs.logIf(new LogKey(this, "firstvictoryrewardid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  648 */         new LogInt(this, JingjiPvp.this.firstvictoryrewardid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  652 */             JingjiPvp.this.firstvictoryrewardid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  656 */     });
/*  657 */     this.firstvictoryrewardid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFivefightrewardid(int _v_)
/*      */   {
/*  664 */     _xdb_verify_unsafe_();
/*  665 */     Logs.logIf(new LogKey(this, "fivefightrewardid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  669 */         new LogInt(this, JingjiPvp.this.fivefightrewardid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  673 */             JingjiPvp.this.fivefightrewardid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  677 */     });
/*  678 */     this.fivefightrewardid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFightcount(int _v_)
/*      */   {
/*  685 */     _xdb_verify_unsafe_();
/*  686 */     Logs.logIf(new LogKey(this, "fightcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  690 */         new LogInt(this, JingjiPvp.this.fightcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  694 */             JingjiPvp.this.fightcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  698 */     });
/*  699 */     this.fightcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVictorycount(int _v_)
/*      */   {
/*  706 */     _xdb_verify_unsafe_();
/*  707 */     Logs.logIf(new LogKey(this, "victorycount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  711 */         new LogInt(this, JingjiPvp.this.victorycount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  715 */             JingjiPvp.this.victorycount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  719 */     });
/*  720 */     this.victorycount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIssendbulletin(boolean _v_)
/*      */   {
/*  727 */     _xdb_verify_unsafe_();
/*  728 */     Logs.logIf(new LogKey(this, "issendbulletin")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  732 */         new LogObject(this, Boolean.valueOf(JingjiPvp.this.issendbulletin))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  736 */             JingjiPvp.this.issendbulletin = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  740 */     });
/*  741 */     this.issendbulletin = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastseasonphase(int _v_)
/*      */   {
/*  748 */     _xdb_verify_unsafe_();
/*  749 */     Logs.logIf(new LogKey(this, "lastseasonphase")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  753 */         new LogInt(this, JingjiPvp.this.lastseasonphase)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  757 */             JingjiPvp.this.lastseasonphase = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  761 */     });
/*  762 */     this.lastseasonphase = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastseasonrank(int _v_)
/*      */   {
/*  769 */     _xdb_verify_unsafe_();
/*  770 */     Logs.logIf(new LogKey(this, "lastseasonrank")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  774 */         new LogInt(this, JingjiPvp.this.lastseasonrank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  778 */             JingjiPvp.this.lastseasonrank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  782 */     });
/*  783 */     this.lastseasonrank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastseasonendtime(long _v_)
/*      */   {
/*  790 */     _xdb_verify_unsafe_();
/*  791 */     Logs.logIf(new LogKey(this, "lastseasonendtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  795 */         new LogLong(this, JingjiPvp.this.lastseasonendtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  799 */             JingjiPvp.this.lastseasonendtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  803 */     });
/*  804 */     this.lastseasonendtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReservedexp(int _v_)
/*      */   {
/*  811 */     _xdb_verify_unsafe_();
/*  812 */     Logs.logIf(new LogKey(this, "reservedexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  816 */         new LogInt(this, JingjiPvp.this.reservedexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  820 */             JingjiPvp.this.reservedexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  824 */     });
/*  825 */     this.reservedexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInittime(long _v_)
/*      */   {
/*  832 */     _xdb_verify_unsafe_();
/*  833 */     Logs.logIf(new LogKey(this, "inittime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  837 */         new LogLong(this, JingjiPvp.this.inittime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  841 */             JingjiPvp.this.inittime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  845 */     });
/*  846 */     this.inittime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMerge_cleared(int _v_)
/*      */   {
/*  853 */     _xdb_verify_unsafe_();
/*  854 */     Logs.logIf(new LogKey(this, "merge_cleared")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  858 */         new LogInt(this, JingjiPvp.this.merge_cleared)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  862 */             JingjiPvp.this.merge_cleared = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  866 */     });
/*  867 */     this.merge_cleared = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  873 */     _xdb_verify_unsafe_();
/*  874 */     JingjiPvp _o_ = null;
/*  875 */     if ((_o1_ instanceof JingjiPvp)) { _o_ = (JingjiPvp)_o1_;
/*  876 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  877 */       return false;
/*  878 */     if (this.jifen != _o_.jifen) return false;
/*  879 */     if (this.buycount != _o_.buycount) return false;
/*  880 */     if (this.buychallengecount != _o_.buychallengecount) return false;
/*  881 */     if (this.challengecount != _o_.challengecount) return false;
/*  882 */     if (this.winpoint != _o_.winpoint) return false;
/*  883 */     if (this.firstvictoryrewardid != _o_.firstvictoryrewardid) return false;
/*  884 */     if (this.fivefightrewardid != _o_.fivefightrewardid) return false;
/*  885 */     if (this.fightcount != _o_.fightcount) return false;
/*  886 */     if (this.victorycount != _o_.victorycount) return false;
/*  887 */     if (this.issendbulletin != _o_.issendbulletin) return false;
/*  888 */     if (this.lastseasonphase != _o_.lastseasonphase) return false;
/*  889 */     if (this.lastseasonrank != _o_.lastseasonrank) return false;
/*  890 */     if (this.lastseasonendtime != _o_.lastseasonendtime) return false;
/*  891 */     if (this.reservedexp != _o_.reservedexp) return false;
/*  892 */     if (this.inittime != _o_.inittime) return false;
/*  893 */     if (this.merge_cleared != _o_.merge_cleared) return false;
/*  894 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  900 */     _xdb_verify_unsafe_();
/*  901 */     int _h_ = 0;
/*  902 */     _h_ += this.jifen;
/*  903 */     _h_ += this.buycount;
/*  904 */     _h_ += this.buychallengecount;
/*  905 */     _h_ += this.challengecount;
/*  906 */     _h_ += this.winpoint;
/*  907 */     _h_ += this.firstvictoryrewardid;
/*  908 */     _h_ += this.fivefightrewardid;
/*  909 */     _h_ += this.fightcount;
/*  910 */     _h_ += this.victorycount;
/*  911 */     _h_ += (this.issendbulletin ? 1231 : 1237);
/*  912 */     _h_ += this.lastseasonphase;
/*  913 */     _h_ += this.lastseasonrank;
/*  914 */     _h_ = (int)(_h_ + this.lastseasonendtime);
/*  915 */     _h_ += this.reservedexp;
/*  916 */     _h_ = (int)(_h_ + this.inittime);
/*  917 */     _h_ += this.merge_cleared;
/*  918 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  924 */     _xdb_verify_unsafe_();
/*  925 */     StringBuilder _sb_ = new StringBuilder();
/*  926 */     _sb_.append("(");
/*  927 */     _sb_.append(this.jifen);
/*  928 */     _sb_.append(",");
/*  929 */     _sb_.append(this.buycount);
/*  930 */     _sb_.append(",");
/*  931 */     _sb_.append(this.buychallengecount);
/*  932 */     _sb_.append(",");
/*  933 */     _sb_.append(this.challengecount);
/*  934 */     _sb_.append(",");
/*  935 */     _sb_.append(this.winpoint);
/*  936 */     _sb_.append(",");
/*  937 */     _sb_.append(this.firstvictoryrewardid);
/*  938 */     _sb_.append(",");
/*  939 */     _sb_.append(this.fivefightrewardid);
/*  940 */     _sb_.append(",");
/*  941 */     _sb_.append(this.fightcount);
/*  942 */     _sb_.append(",");
/*  943 */     _sb_.append(this.victorycount);
/*  944 */     _sb_.append(",");
/*  945 */     _sb_.append(this.issendbulletin);
/*  946 */     _sb_.append(",");
/*  947 */     _sb_.append(this.lastseasonphase);
/*  948 */     _sb_.append(",");
/*  949 */     _sb_.append(this.lastseasonrank);
/*  950 */     _sb_.append(",");
/*  951 */     _sb_.append(this.lastseasonendtime);
/*  952 */     _sb_.append(",");
/*  953 */     _sb_.append(this.reservedexp);
/*  954 */     _sb_.append(",");
/*  955 */     _sb_.append(this.inittime);
/*  956 */     _sb_.append(",");
/*  957 */     _sb_.append(this.merge_cleared);
/*  958 */     _sb_.append(")");
/*  959 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/*  965 */     ListenableBean lb = new ListenableBean();
/*  966 */     lb.add(new ListenableChanged().setVarName("jifen"));
/*  967 */     lb.add(new ListenableChanged().setVarName("buycount"));
/*  968 */     lb.add(new ListenableChanged().setVarName("buychallengecount"));
/*  969 */     lb.add(new ListenableChanged().setVarName("challengecount"));
/*  970 */     lb.add(new ListenableChanged().setVarName("winpoint"));
/*  971 */     lb.add(new ListenableChanged().setVarName("firstvictoryrewardid"));
/*  972 */     lb.add(new ListenableChanged().setVarName("fivefightrewardid"));
/*  973 */     lb.add(new ListenableChanged().setVarName("fightcount"));
/*  974 */     lb.add(new ListenableChanged().setVarName("victorycount"));
/*  975 */     lb.add(new ListenableChanged().setVarName("issendbulletin"));
/*  976 */     lb.add(new ListenableChanged().setVarName("lastseasonphase"));
/*  977 */     lb.add(new ListenableChanged().setVarName("lastseasonrank"));
/*  978 */     lb.add(new ListenableChanged().setVarName("lastseasonendtime"));
/*  979 */     lb.add(new ListenableChanged().setVarName("reservedexp"));
/*  980 */     lb.add(new ListenableChanged().setVarName("inittime"));
/*  981 */     lb.add(new ListenableChanged().setVarName("merge_cleared"));
/*  982 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.JingjiPvp {
/*      */     private Const() {}
/*      */     
/*      */     JingjiPvp nThis() {
/*  989 */       return JingjiPvp.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  995 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.JingjiPvp copy()
/*      */     {
/* 1001 */       return JingjiPvp.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.JingjiPvp toData()
/*      */     {
/* 1007 */       return JingjiPvp.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.JingjiPvp toBean()
/*      */     {
/* 1012 */       return JingjiPvp.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.JingjiPvp toDataIf()
/*      */     {
/* 1018 */       return JingjiPvp.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.JingjiPvp toBeanIf()
/*      */     {
/* 1023 */       return JingjiPvp.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getJifen()
/*      */     {
/* 1030 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1031 */       return JingjiPvp.this.jifen;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuycount()
/*      */     {
/* 1038 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1039 */       return JingjiPvp.this.buycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuychallengecount()
/*      */     {
/* 1046 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1047 */       return JingjiPvp.this.buychallengecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChallengecount()
/*      */     {
/* 1054 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1055 */       return JingjiPvp.this.challengecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWinpoint()
/*      */     {
/* 1062 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1063 */       return JingjiPvp.this.winpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFirstvictoryrewardid()
/*      */     {
/* 1070 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1071 */       return JingjiPvp.this.firstvictoryrewardid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFivefightrewardid()
/*      */     {
/* 1078 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1079 */       return JingjiPvp.this.fivefightrewardid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightcount()
/*      */     {
/* 1086 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1087 */       return JingjiPvp.this.fightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVictorycount()
/*      */     {
/* 1094 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1095 */       return JingjiPvp.this.victorycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIssendbulletin()
/*      */     {
/* 1102 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1103 */       return JingjiPvp.this.issendbulletin;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLastseasonphase()
/*      */     {
/* 1110 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1111 */       return JingjiPvp.this.lastseasonphase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLastseasonrank()
/*      */     {
/* 1118 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1119 */       return JingjiPvp.this.lastseasonrank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastseasonendtime()
/*      */     {
/* 1126 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1127 */       return JingjiPvp.this.lastseasonendtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReservedexp()
/*      */     {
/* 1134 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1135 */       return JingjiPvp.this.reservedexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInittime()
/*      */     {
/* 1142 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1143 */       return JingjiPvp.this.inittime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMerge_cleared()
/*      */     {
/* 1150 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1151 */       return JingjiPvp.this.merge_cleared;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJifen(int _v_)
/*      */     {
/* 1158 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1159 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuycount(int _v_)
/*      */     {
/* 1166 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1167 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuychallengecount(int _v_)
/*      */     {
/* 1174 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1175 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChallengecount(int _v_)
/*      */     {
/* 1182 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1183 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWinpoint(int _v_)
/*      */     {
/* 1190 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1191 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirstvictoryrewardid(int _v_)
/*      */     {
/* 1198 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1199 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFivefightrewardid(int _v_)
/*      */     {
/* 1206 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1207 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightcount(int _v_)
/*      */     {
/* 1214 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1215 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVictorycount(int _v_)
/*      */     {
/* 1222 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1223 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssendbulletin(boolean _v_)
/*      */     {
/* 1230 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1231 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastseasonphase(int _v_)
/*      */     {
/* 1238 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1239 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastseasonrank(int _v_)
/*      */     {
/* 1246 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1247 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastseasonendtime(long _v_)
/*      */     {
/* 1254 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1255 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReservedexp(int _v_)
/*      */     {
/* 1262 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1263 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInittime(long _v_)
/*      */     {
/* 1270 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1271 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMerge_cleared(int _v_)
/*      */     {
/* 1278 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1279 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1285 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1286 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1292 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1293 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1299 */       return JingjiPvp.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1305 */       return JingjiPvp.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1311 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1312 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1318 */       return JingjiPvp.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1324 */       return JingjiPvp.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1330 */       JingjiPvp.this._xdb_verify_unsafe_();
/* 1331 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1337 */       return JingjiPvp.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1343 */       return JingjiPvp.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1349 */       return JingjiPvp.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1355 */       return JingjiPvp.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1361 */       return JingjiPvp.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1367 */       return JingjiPvp.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1373 */       return JingjiPvp.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.JingjiPvp
/*      */   {
/*      */     private int jifen;
/*      */     
/*      */     private int buycount;
/*      */     
/*      */     private int buychallengecount;
/*      */     
/*      */     private int challengecount;
/*      */     
/*      */     private int winpoint;
/*      */     
/*      */     private int firstvictoryrewardid;
/*      */     
/*      */     private int fivefightrewardid;
/*      */     
/*      */     private int fightcount;
/*      */     
/*      */     private int victorycount;
/*      */     
/*      */     private boolean issendbulletin;
/*      */     
/*      */     private int lastseasonphase;
/*      */     
/*      */     private int lastseasonrank;
/*      */     
/*      */     private long lastseasonendtime;
/*      */     
/*      */     private int reservedexp;
/*      */     
/*      */     private long inittime;
/*      */     
/*      */     private int merge_cleared;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1415 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1420 */       this.jifen = 0;
/* 1421 */       this.buycount = 0;
/* 1422 */       this.buychallengecount = 0;
/* 1423 */       this.challengecount = 0;
/* 1424 */       this.winpoint = 0;
/* 1425 */       this.firstvictoryrewardid = -1;
/* 1426 */       this.fivefightrewardid = -1;
/* 1427 */       this.fightcount = 0;
/* 1428 */       this.victorycount = 0;
/* 1429 */       this.issendbulletin = false;
/* 1430 */       this.lastseasonphase = 0;
/* 1431 */       this.lastseasonrank = 0;
/* 1432 */       this.lastseasonendtime = 0L;
/* 1433 */       this.reservedexp = 0;
/* 1434 */       this.inittime = 0L;
/* 1435 */       this.merge_cleared = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.JingjiPvp _o1_)
/*      */     {
/* 1440 */       if ((_o1_ instanceof JingjiPvp)) { assign((JingjiPvp)_o1_);
/* 1441 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1442 */       } else if ((_o1_ instanceof JingjiPvp.Const)) assign(((JingjiPvp.Const)_o1_).nThis()); else {
/* 1443 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(JingjiPvp _o_) {
/* 1448 */       this.jifen = _o_.jifen;
/* 1449 */       this.buycount = _o_.buycount;
/* 1450 */       this.buychallengecount = _o_.buychallengecount;
/* 1451 */       this.challengecount = _o_.challengecount;
/* 1452 */       this.winpoint = _o_.winpoint;
/* 1453 */       this.firstvictoryrewardid = _o_.firstvictoryrewardid;
/* 1454 */       this.fivefightrewardid = _o_.fivefightrewardid;
/* 1455 */       this.fightcount = _o_.fightcount;
/* 1456 */       this.victorycount = _o_.victorycount;
/* 1457 */       this.issendbulletin = _o_.issendbulletin;
/* 1458 */       this.lastseasonphase = _o_.lastseasonphase;
/* 1459 */       this.lastseasonrank = _o_.lastseasonrank;
/* 1460 */       this.lastseasonendtime = _o_.lastseasonendtime;
/* 1461 */       this.reservedexp = _o_.reservedexp;
/* 1462 */       this.inittime = _o_.inittime;
/* 1463 */       this.merge_cleared = _o_.merge_cleared;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1468 */       this.jifen = _o_.jifen;
/* 1469 */       this.buycount = _o_.buycount;
/* 1470 */       this.buychallengecount = _o_.buychallengecount;
/* 1471 */       this.challengecount = _o_.challengecount;
/* 1472 */       this.winpoint = _o_.winpoint;
/* 1473 */       this.firstvictoryrewardid = _o_.firstvictoryrewardid;
/* 1474 */       this.fivefightrewardid = _o_.fivefightrewardid;
/* 1475 */       this.fightcount = _o_.fightcount;
/* 1476 */       this.victorycount = _o_.victorycount;
/* 1477 */       this.issendbulletin = _o_.issendbulletin;
/* 1478 */       this.lastseasonphase = _o_.lastseasonphase;
/* 1479 */       this.lastseasonrank = _o_.lastseasonrank;
/* 1480 */       this.lastseasonendtime = _o_.lastseasonendtime;
/* 1481 */       this.reservedexp = _o_.reservedexp;
/* 1482 */       this.inittime = _o_.inittime;
/* 1483 */       this.merge_cleared = _o_.merge_cleared;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1489 */       _os_.marshal(this.jifen);
/* 1490 */       _os_.marshal(this.buycount);
/* 1491 */       _os_.marshal(this.buychallengecount);
/* 1492 */       _os_.marshal(this.challengecount);
/* 1493 */       _os_.marshal(this.winpoint);
/* 1494 */       _os_.marshal(this.firstvictoryrewardid);
/* 1495 */       _os_.marshal(this.fivefightrewardid);
/* 1496 */       _os_.marshal(this.fightcount);
/* 1497 */       _os_.marshal(this.victorycount);
/* 1498 */       _os_.marshal(this.issendbulletin);
/* 1499 */       _os_.marshal(this.lastseasonphase);
/* 1500 */       _os_.marshal(this.lastseasonrank);
/* 1501 */       _os_.marshal(this.lastseasonendtime);
/* 1502 */       _os_.marshal(this.reservedexp);
/* 1503 */       _os_.marshal(this.inittime);
/* 1504 */       _os_.marshal(this.merge_cleared);
/* 1505 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1511 */       this.jifen = _os_.unmarshal_int();
/* 1512 */       this.buycount = _os_.unmarshal_int();
/* 1513 */       this.buychallengecount = _os_.unmarshal_int();
/* 1514 */       this.challengecount = _os_.unmarshal_int();
/* 1515 */       this.winpoint = _os_.unmarshal_int();
/* 1516 */       this.firstvictoryrewardid = _os_.unmarshal_int();
/* 1517 */       this.fivefightrewardid = _os_.unmarshal_int();
/* 1518 */       this.fightcount = _os_.unmarshal_int();
/* 1519 */       this.victorycount = _os_.unmarshal_int();
/* 1520 */       this.issendbulletin = _os_.unmarshal_boolean();
/* 1521 */       this.lastseasonphase = _os_.unmarshal_int();
/* 1522 */       this.lastseasonrank = _os_.unmarshal_int();
/* 1523 */       this.lastseasonendtime = _os_.unmarshal_long();
/* 1524 */       this.reservedexp = _os_.unmarshal_int();
/* 1525 */       this.inittime = _os_.unmarshal_long();
/* 1526 */       this.merge_cleared = _os_.unmarshal_int();
/* 1527 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1533 */       int _size_ = 0;
/* 1534 */       _size_ += CodedOutputStream.computeInt32Size(1, this.jifen);
/* 1535 */       _size_ += CodedOutputStream.computeInt32Size(2, this.buycount);
/* 1536 */       _size_ += CodedOutputStream.computeInt32Size(3, this.buychallengecount);
/* 1537 */       _size_ += CodedOutputStream.computeInt32Size(4, this.challengecount);
/* 1538 */       _size_ += CodedOutputStream.computeInt32Size(5, this.winpoint);
/* 1539 */       _size_ += CodedOutputStream.computeInt32Size(6, this.firstvictoryrewardid);
/* 1540 */       _size_ += CodedOutputStream.computeInt32Size(7, this.fivefightrewardid);
/* 1541 */       _size_ += CodedOutputStream.computeInt32Size(8, this.fightcount);
/* 1542 */       _size_ += CodedOutputStream.computeInt32Size(9, this.victorycount);
/* 1543 */       _size_ += CodedOutputStream.computeBoolSize(10, this.issendbulletin);
/* 1544 */       _size_ += CodedOutputStream.computeInt32Size(11, this.lastseasonphase);
/* 1545 */       _size_ += CodedOutputStream.computeInt32Size(12, this.lastseasonrank);
/* 1546 */       _size_ += CodedOutputStream.computeInt64Size(13, this.lastseasonendtime);
/* 1547 */       _size_ += CodedOutputStream.computeInt32Size(14, this.reservedexp);
/* 1548 */       _size_ += CodedOutputStream.computeInt64Size(15, this.inittime);
/* 1549 */       _size_ += CodedOutputStream.computeInt32Size(16, this.merge_cleared);
/* 1550 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1558 */         _output_.writeInt32(1, this.jifen);
/* 1559 */         _output_.writeInt32(2, this.buycount);
/* 1560 */         _output_.writeInt32(3, this.buychallengecount);
/* 1561 */         _output_.writeInt32(4, this.challengecount);
/* 1562 */         _output_.writeInt32(5, this.winpoint);
/* 1563 */         _output_.writeInt32(6, this.firstvictoryrewardid);
/* 1564 */         _output_.writeInt32(7, this.fivefightrewardid);
/* 1565 */         _output_.writeInt32(8, this.fightcount);
/* 1566 */         _output_.writeInt32(9, this.victorycount);
/* 1567 */         _output_.writeBool(10, this.issendbulletin);
/* 1568 */         _output_.writeInt32(11, this.lastseasonphase);
/* 1569 */         _output_.writeInt32(12, this.lastseasonrank);
/* 1570 */         _output_.writeInt64(13, this.lastseasonendtime);
/* 1571 */         _output_.writeInt32(14, this.reservedexp);
/* 1572 */         _output_.writeInt64(15, this.inittime);
/* 1573 */         _output_.writeInt32(16, this.merge_cleared);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1577 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1579 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1587 */         boolean done = false;
/* 1588 */         while (!done)
/*      */         {
/* 1590 */           int tag = _input_.readTag();
/* 1591 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1595 */             done = true;
/* 1596 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1600 */             this.jifen = _input_.readInt32();
/* 1601 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1605 */             this.buycount = _input_.readInt32();
/* 1606 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1610 */             this.buychallengecount = _input_.readInt32();
/* 1611 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1615 */             this.challengecount = _input_.readInt32();
/* 1616 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1620 */             this.winpoint = _input_.readInt32();
/* 1621 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1625 */             this.firstvictoryrewardid = _input_.readInt32();
/* 1626 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1630 */             this.fivefightrewardid = _input_.readInt32();
/* 1631 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1635 */             this.fightcount = _input_.readInt32();
/* 1636 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1640 */             this.victorycount = _input_.readInt32();
/* 1641 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1645 */             this.issendbulletin = _input_.readBool();
/* 1646 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1650 */             this.lastseasonphase = _input_.readInt32();
/* 1651 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1655 */             this.lastseasonrank = _input_.readInt32();
/* 1656 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1660 */             this.lastseasonendtime = _input_.readInt64();
/* 1661 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 1665 */             this.reservedexp = _input_.readInt32();
/* 1666 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 1670 */             this.inittime = _input_.readInt64();
/* 1671 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 1675 */             this.merge_cleared = _input_.readInt32();
/* 1676 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1680 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1682 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1691 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1695 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1697 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.JingjiPvp copy()
/*      */     {
/* 1703 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.JingjiPvp toData()
/*      */     {
/* 1709 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.JingjiPvp toBean()
/*      */     {
/* 1714 */       return new JingjiPvp(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.JingjiPvp toDataIf()
/*      */     {
/* 1720 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.JingjiPvp toBeanIf()
/*      */     {
/* 1725 */       return new JingjiPvp(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1731 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1735 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1743 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1747 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1751 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1755 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getJifen()
/*      */     {
/* 1762 */       return this.jifen;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuycount()
/*      */     {
/* 1769 */       return this.buycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuychallengecount()
/*      */     {
/* 1776 */       return this.buychallengecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChallengecount()
/*      */     {
/* 1783 */       return this.challengecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWinpoint()
/*      */     {
/* 1790 */       return this.winpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFirstvictoryrewardid()
/*      */     {
/* 1797 */       return this.firstvictoryrewardid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFivefightrewardid()
/*      */     {
/* 1804 */       return this.fivefightrewardid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightcount()
/*      */     {
/* 1811 */       return this.fightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVictorycount()
/*      */     {
/* 1818 */       return this.victorycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIssendbulletin()
/*      */     {
/* 1825 */       return this.issendbulletin;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLastseasonphase()
/*      */     {
/* 1832 */       return this.lastseasonphase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLastseasonrank()
/*      */     {
/* 1839 */       return this.lastseasonrank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastseasonendtime()
/*      */     {
/* 1846 */       return this.lastseasonendtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReservedexp()
/*      */     {
/* 1853 */       return this.reservedexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInittime()
/*      */     {
/* 1860 */       return this.inittime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMerge_cleared()
/*      */     {
/* 1867 */       return this.merge_cleared;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJifen(int _v_)
/*      */     {
/* 1874 */       this.jifen = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuycount(int _v_)
/*      */     {
/* 1881 */       this.buycount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuychallengecount(int _v_)
/*      */     {
/* 1888 */       this.buychallengecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChallengecount(int _v_)
/*      */     {
/* 1895 */       this.challengecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWinpoint(int _v_)
/*      */     {
/* 1902 */       this.winpoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirstvictoryrewardid(int _v_)
/*      */     {
/* 1909 */       this.firstvictoryrewardid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFivefightrewardid(int _v_)
/*      */     {
/* 1916 */       this.fivefightrewardid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightcount(int _v_)
/*      */     {
/* 1923 */       this.fightcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVictorycount(int _v_)
/*      */     {
/* 1930 */       this.victorycount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssendbulletin(boolean _v_)
/*      */     {
/* 1937 */       this.issendbulletin = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastseasonphase(int _v_)
/*      */     {
/* 1944 */       this.lastseasonphase = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastseasonrank(int _v_)
/*      */     {
/* 1951 */       this.lastseasonrank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastseasonendtime(long _v_)
/*      */     {
/* 1958 */       this.lastseasonendtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReservedexp(int _v_)
/*      */     {
/* 1965 */       this.reservedexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInittime(long _v_)
/*      */     {
/* 1972 */       this.inittime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMerge_cleared(int _v_)
/*      */     {
/* 1979 */       this.merge_cleared = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1985 */       if (!(_o1_ instanceof Data)) return false;
/* 1986 */       Data _o_ = (Data)_o1_;
/* 1987 */       if (this.jifen != _o_.jifen) return false;
/* 1988 */       if (this.buycount != _o_.buycount) return false;
/* 1989 */       if (this.buychallengecount != _o_.buychallengecount) return false;
/* 1990 */       if (this.challengecount != _o_.challengecount) return false;
/* 1991 */       if (this.winpoint != _o_.winpoint) return false;
/* 1992 */       if (this.firstvictoryrewardid != _o_.firstvictoryrewardid) return false;
/* 1993 */       if (this.fivefightrewardid != _o_.fivefightrewardid) return false;
/* 1994 */       if (this.fightcount != _o_.fightcount) return false;
/* 1995 */       if (this.victorycount != _o_.victorycount) return false;
/* 1996 */       if (this.issendbulletin != _o_.issendbulletin) return false;
/* 1997 */       if (this.lastseasonphase != _o_.lastseasonphase) return false;
/* 1998 */       if (this.lastseasonrank != _o_.lastseasonrank) return false;
/* 1999 */       if (this.lastseasonendtime != _o_.lastseasonendtime) return false;
/* 2000 */       if (this.reservedexp != _o_.reservedexp) return false;
/* 2001 */       if (this.inittime != _o_.inittime) return false;
/* 2002 */       if (this.merge_cleared != _o_.merge_cleared) return false;
/* 2003 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 2009 */       int _h_ = 0;
/* 2010 */       _h_ += this.jifen;
/* 2011 */       _h_ += this.buycount;
/* 2012 */       _h_ += this.buychallengecount;
/* 2013 */       _h_ += this.challengecount;
/* 2014 */       _h_ += this.winpoint;
/* 2015 */       _h_ += this.firstvictoryrewardid;
/* 2016 */       _h_ += this.fivefightrewardid;
/* 2017 */       _h_ += this.fightcount;
/* 2018 */       _h_ += this.victorycount;
/* 2019 */       _h_ += (this.issendbulletin ? 1231 : 1237);
/* 2020 */       _h_ += this.lastseasonphase;
/* 2021 */       _h_ += this.lastseasonrank;
/* 2022 */       _h_ = (int)(_h_ + this.lastseasonendtime);
/* 2023 */       _h_ += this.reservedexp;
/* 2024 */       _h_ = (int)(_h_ + this.inittime);
/* 2025 */       _h_ += this.merge_cleared;
/* 2026 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2032 */       StringBuilder _sb_ = new StringBuilder();
/* 2033 */       _sb_.append("(");
/* 2034 */       _sb_.append(this.jifen);
/* 2035 */       _sb_.append(",");
/* 2036 */       _sb_.append(this.buycount);
/* 2037 */       _sb_.append(",");
/* 2038 */       _sb_.append(this.buychallengecount);
/* 2039 */       _sb_.append(",");
/* 2040 */       _sb_.append(this.challengecount);
/* 2041 */       _sb_.append(",");
/* 2042 */       _sb_.append(this.winpoint);
/* 2043 */       _sb_.append(",");
/* 2044 */       _sb_.append(this.firstvictoryrewardid);
/* 2045 */       _sb_.append(",");
/* 2046 */       _sb_.append(this.fivefightrewardid);
/* 2047 */       _sb_.append(",");
/* 2048 */       _sb_.append(this.fightcount);
/* 2049 */       _sb_.append(",");
/* 2050 */       _sb_.append(this.victorycount);
/* 2051 */       _sb_.append(",");
/* 2052 */       _sb_.append(this.issendbulletin);
/* 2053 */       _sb_.append(",");
/* 2054 */       _sb_.append(this.lastseasonphase);
/* 2055 */       _sb_.append(",");
/* 2056 */       _sb_.append(this.lastseasonrank);
/* 2057 */       _sb_.append(",");
/* 2058 */       _sb_.append(this.lastseasonendtime);
/* 2059 */       _sb_.append(",");
/* 2060 */       _sb_.append(this.reservedexp);
/* 2061 */       _sb_.append(",");
/* 2062 */       _sb_.append(this.inittime);
/* 2063 */       _sb_.append(",");
/* 2064 */       _sb_.append(this.merge_cleared);
/* 2065 */       _sb_.append(")");
/* 2066 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\JingjiPvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */