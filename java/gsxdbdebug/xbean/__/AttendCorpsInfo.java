/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.ByteString;
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
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class AttendCorpsInfo extends XBean implements xbean.AttendCorpsInfo
/*      */ {
/*      */   private int zoneid;
/*      */   private ArrayList<Long> members;
/*      */   private float vote_stage_start_average_fight_value;
/*      */   private int vote_num;
/*      */   private long vote_num_timestamp;
/*      */   private int round_robin_point;
/*      */   private int round_robin_win_num;
/*      */   private int round_robin_lose_num;
/*      */   private float round_robin_end_average_fight_value;
/*      */   private String name;
/*      */   private int badge;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   38 */     this.zoneid = -1;
/*   39 */     this.members.clear();
/*   40 */     this.vote_stage_start_average_fight_value = 0.0F;
/*   41 */     this.vote_num = 0;
/*   42 */     this.vote_num_timestamp = 0L;
/*   43 */     this.round_robin_point = 0;
/*   44 */     this.round_robin_win_num = 0;
/*   45 */     this.round_robin_lose_num = 0;
/*   46 */     this.round_robin_end_average_fight_value = 0.0F;
/*   47 */     this.name = "";
/*   48 */     this.badge = 0;
/*      */   }
/*      */   
/*      */   AttendCorpsInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     this.zoneid = -1;
/*   55 */     this.members = new ArrayList();
/*   56 */     this.vote_stage_start_average_fight_value = 0.0F;
/*   57 */     this.vote_num = 0;
/*   58 */     this.vote_num_timestamp = 0L;
/*   59 */     this.round_robin_point = 0;
/*   60 */     this.round_robin_win_num = 0;
/*   61 */     this.round_robin_lose_num = 0;
/*   62 */     this.round_robin_end_average_fight_value = 0.0F;
/*   63 */     this.name = "";
/*      */   }
/*      */   
/*      */   public AttendCorpsInfo()
/*      */   {
/*   68 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AttendCorpsInfo(AttendCorpsInfo _o_)
/*      */   {
/*   73 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AttendCorpsInfo(xbean.AttendCorpsInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   78 */     super(_xp_, _vn_);
/*   79 */     if ((_o1_ instanceof AttendCorpsInfo)) { assign((AttendCorpsInfo)_o1_);
/*   80 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   81 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   82 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AttendCorpsInfo _o_) {
/*   87 */     _o_._xdb_verify_unsafe_();
/*   88 */     this.zoneid = _o_.zoneid;
/*   89 */     this.members = new ArrayList();
/*   90 */     this.members.addAll(_o_.members);
/*   91 */     this.vote_stage_start_average_fight_value = _o_.vote_stage_start_average_fight_value;
/*   92 */     this.vote_num = _o_.vote_num;
/*   93 */     this.vote_num_timestamp = _o_.vote_num_timestamp;
/*   94 */     this.round_robin_point = _o_.round_robin_point;
/*   95 */     this.round_robin_win_num = _o_.round_robin_win_num;
/*   96 */     this.round_robin_lose_num = _o_.round_robin_lose_num;
/*   97 */     this.round_robin_end_average_fight_value = _o_.round_robin_end_average_fight_value;
/*   98 */     this.name = _o_.name;
/*   99 */     this.badge = _o_.badge;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  104 */     this.zoneid = _o_.zoneid;
/*  105 */     this.members = new ArrayList();
/*  106 */     this.members.addAll(_o_.members);
/*  107 */     this.vote_stage_start_average_fight_value = _o_.vote_stage_start_average_fight_value;
/*  108 */     this.vote_num = _o_.vote_num;
/*  109 */     this.vote_num_timestamp = _o_.vote_num_timestamp;
/*  110 */     this.round_robin_point = _o_.round_robin_point;
/*  111 */     this.round_robin_win_num = _o_.round_robin_win_num;
/*  112 */     this.round_robin_lose_num = _o_.round_robin_lose_num;
/*  113 */     this.round_robin_end_average_fight_value = _o_.round_robin_end_average_fight_value;
/*  114 */     this.name = _o_.name;
/*  115 */     this.badge = _o_.badge;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*  122 */     _os_.marshal(this.zoneid);
/*  123 */     _os_.compact_uint32(this.members.size());
/*  124 */     for (Long _v_ : this.members)
/*      */     {
/*  126 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  128 */     _os_.marshal(this.vote_stage_start_average_fight_value);
/*  129 */     _os_.marshal(this.vote_num);
/*  130 */     _os_.marshal(this.vote_num_timestamp);
/*  131 */     _os_.marshal(this.round_robin_point);
/*  132 */     _os_.marshal(this.round_robin_win_num);
/*  133 */     _os_.marshal(this.round_robin_lose_num);
/*  134 */     _os_.marshal(this.round_robin_end_average_fight_value);
/*  135 */     _os_.marshal(this.name, "UTF-16LE");
/*  136 */     _os_.marshal(this.badge);
/*  137 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  143 */     _xdb_verify_unsafe_();
/*  144 */     this.zoneid = _os_.unmarshal_int();
/*  145 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  147 */       long _v_ = 0L;
/*  148 */       _v_ = _os_.unmarshal_long();
/*  149 */       this.members.add(Long.valueOf(_v_));
/*      */     }
/*  151 */     this.vote_stage_start_average_fight_value = _os_.unmarshal_float();
/*  152 */     this.vote_num = _os_.unmarshal_int();
/*  153 */     this.vote_num_timestamp = _os_.unmarshal_long();
/*  154 */     this.round_robin_point = _os_.unmarshal_int();
/*  155 */     this.round_robin_win_num = _os_.unmarshal_int();
/*  156 */     this.round_robin_lose_num = _os_.unmarshal_int();
/*  157 */     this.round_robin_end_average_fight_value = _os_.unmarshal_float();
/*  158 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  159 */     this.badge = _os_.unmarshal_int();
/*  160 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  166 */     _xdb_verify_unsafe_();
/*  167 */     int _size_ = 0;
/*  168 */     _size_ += CodedOutputStream.computeInt32Size(1, this.zoneid);
/*  169 */     for (Long _v_ : this.members)
/*      */     {
/*  171 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  173 */     _size_ += CodedOutputStream.computeFloatSize(3, this.vote_stage_start_average_fight_value);
/*  174 */     _size_ += CodedOutputStream.computeInt32Size(4, this.vote_num);
/*  175 */     _size_ += CodedOutputStream.computeInt64Size(5, this.vote_num_timestamp);
/*  176 */     _size_ += CodedOutputStream.computeInt32Size(6, this.round_robin_point);
/*  177 */     _size_ += CodedOutputStream.computeInt32Size(7, this.round_robin_win_num);
/*  178 */     _size_ += CodedOutputStream.computeInt32Size(8, this.round_robin_lose_num);
/*  179 */     _size_ += CodedOutputStream.computeFloatSize(9, this.round_robin_end_average_fight_value);
/*      */     try
/*      */     {
/*  182 */       _size_ += CodedOutputStream.computeBytesSize(10, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  186 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  188 */     _size_ += CodedOutputStream.computeInt32Size(11, this.badge);
/*  189 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  195 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  198 */       _output_.writeInt32(1, this.zoneid);
/*  199 */       for (Long _v_ : this.members)
/*      */       {
/*  201 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  203 */       _output_.writeFloat(3, this.vote_stage_start_average_fight_value);
/*  204 */       _output_.writeInt32(4, this.vote_num);
/*  205 */       _output_.writeInt64(5, this.vote_num_timestamp);
/*  206 */       _output_.writeInt32(6, this.round_robin_point);
/*  207 */       _output_.writeInt32(7, this.round_robin_win_num);
/*  208 */       _output_.writeInt32(8, this.round_robin_lose_num);
/*  209 */       _output_.writeFloat(9, this.round_robin_end_average_fight_value);
/*  210 */       _output_.writeBytes(10, ByteString.copyFrom(this.name, "UTF-16LE"));
/*  211 */       _output_.writeInt32(11, this.badge);
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
/*      */         case 8: 
/*  239 */           this.zoneid = _input_.readInt32();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  244 */           long _v_ = 0L;
/*  245 */           _v_ = _input_.readInt64();
/*  246 */           this.members.add(Long.valueOf(_v_));
/*  247 */           break;
/*      */         
/*      */ 
/*      */         case 29: 
/*  251 */           this.vote_stage_start_average_fight_value = _input_.readFloat();
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  256 */           this.vote_num = _input_.readInt32();
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  261 */           this.vote_num_timestamp = _input_.readInt64();
/*  262 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  266 */           this.round_robin_point = _input_.readInt32();
/*  267 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  271 */           this.round_robin_win_num = _input_.readInt32();
/*  272 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  276 */           this.round_robin_lose_num = _input_.readInt32();
/*  277 */           break;
/*      */         
/*      */ 
/*      */         case 77: 
/*  281 */           this.round_robin_end_average_fight_value = _input_.readFloat();
/*  282 */           break;
/*      */         
/*      */ 
/*      */         case 82: 
/*  286 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  287 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  291 */           this.badge = _input_.readInt32();
/*  292 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  296 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  298 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  307 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  311 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  313 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AttendCorpsInfo copy()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return new AttendCorpsInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AttendCorpsInfo toData()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AttendCorpsInfo toBean()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return new AttendCorpsInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AttendCorpsInfo toDataIf()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AttendCorpsInfo toBeanIf()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getZoneid()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this.zoneid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getMembers()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return Logs.logList(new LogKey(this, "members"), this.members);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getMembersAsData()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*      */     
/*  377 */     AttendCorpsInfo _o_ = this;
/*  378 */     List<Long> members = new ArrayList();
/*  379 */     members.addAll(_o_.members);
/*  380 */     return members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public float getVote_stage_start_average_fight_value()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return this.vote_stage_start_average_fight_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVote_num()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     return this.vote_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getVote_num_timestamp()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     return this.vote_num_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRound_robin_point()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     return this.round_robin_point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRound_robin_win_num()
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     return this.round_robin_win_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRound_robin_lose_num()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return this.round_robin_lose_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public float getRound_robin_end_average_fight_value()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     return this.round_robin_end_average_fight_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBadge()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     return this.badge;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setZoneid(int _v_)
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     Logs.logIf(new LogKey(this, "zoneid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  472 */         new LogInt(this, AttendCorpsInfo.this.zoneid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  476 */             AttendCorpsInfo.this.zoneid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  480 */     });
/*  481 */     this.zoneid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVote_stage_start_average_fight_value(float _v_)
/*      */   {
/*  488 */     _xdb_verify_unsafe_();
/*  489 */     Logs.logIf(new LogKey(this, "vote_stage_start_average_fight_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  493 */         new xdb.logs.LogFloat(this, AttendCorpsInfo.this.vote_stage_start_average_fight_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  497 */             AttendCorpsInfo.this.vote_stage_start_average_fight_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  501 */     });
/*  502 */     this.vote_stage_start_average_fight_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVote_num(int _v_)
/*      */   {
/*  509 */     _xdb_verify_unsafe_();
/*  510 */     Logs.logIf(new LogKey(this, "vote_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  514 */         new LogInt(this, AttendCorpsInfo.this.vote_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  518 */             AttendCorpsInfo.this.vote_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  522 */     });
/*  523 */     this.vote_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVote_num_timestamp(long _v_)
/*      */   {
/*  530 */     _xdb_verify_unsafe_();
/*  531 */     Logs.logIf(new LogKey(this, "vote_num_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  535 */         new xdb.logs.LogLong(this, AttendCorpsInfo.this.vote_num_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  539 */             AttendCorpsInfo.this.vote_num_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  543 */     });
/*  544 */     this.vote_num_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRound_robin_point(int _v_)
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     Logs.logIf(new LogKey(this, "round_robin_point")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  556 */         new LogInt(this, AttendCorpsInfo.this.round_robin_point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  560 */             AttendCorpsInfo.this.round_robin_point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  564 */     });
/*  565 */     this.round_robin_point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRound_robin_win_num(int _v_)
/*      */   {
/*  572 */     _xdb_verify_unsafe_();
/*  573 */     Logs.logIf(new LogKey(this, "round_robin_win_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  577 */         new LogInt(this, AttendCorpsInfo.this.round_robin_win_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  581 */             AttendCorpsInfo.this.round_robin_win_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  585 */     });
/*  586 */     this.round_robin_win_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRound_robin_lose_num(int _v_)
/*      */   {
/*  593 */     _xdb_verify_unsafe_();
/*  594 */     Logs.logIf(new LogKey(this, "round_robin_lose_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  598 */         new LogInt(this, AttendCorpsInfo.this.round_robin_lose_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  602 */             AttendCorpsInfo.this.round_robin_lose_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  606 */     });
/*  607 */     this.round_robin_lose_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRound_robin_end_average_fight_value(float _v_)
/*      */   {
/*  614 */     _xdb_verify_unsafe_();
/*  615 */     Logs.logIf(new LogKey(this, "round_robin_end_average_fight_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  619 */         new xdb.logs.LogFloat(this, AttendCorpsInfo.this.round_robin_end_average_fight_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  623 */             AttendCorpsInfo.this.round_robin_end_average_fight_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  627 */     });
/*  628 */     this.round_robin_end_average_fight_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/*  635 */     _xdb_verify_unsafe_();
/*  636 */     if (null == _v_)
/*  637 */       throw new NullPointerException();
/*  638 */     Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  642 */         new xdb.logs.LogString(this, AttendCorpsInfo.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  646 */             AttendCorpsInfo.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  650 */     });
/*  651 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/*  658 */     _xdb_verify_unsafe_();
/*  659 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBadge(int _v_)
/*      */   {
/*  666 */     _xdb_verify_unsafe_();
/*  667 */     Logs.logIf(new LogKey(this, "badge")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  671 */         new LogInt(this, AttendCorpsInfo.this.badge)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  675 */             AttendCorpsInfo.this.badge = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  679 */     });
/*  680 */     this.badge = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  686 */     _xdb_verify_unsafe_();
/*  687 */     AttendCorpsInfo _o_ = null;
/*  688 */     if ((_o1_ instanceof AttendCorpsInfo)) { _o_ = (AttendCorpsInfo)_o1_;
/*  689 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  690 */       return false;
/*  691 */     if (this.zoneid != _o_.zoneid) return false;
/*  692 */     if (!this.members.equals(_o_.members)) return false;
/*  693 */     if (this.vote_stage_start_average_fight_value != _o_.vote_stage_start_average_fight_value) return false;
/*  694 */     if (this.vote_num != _o_.vote_num) return false;
/*  695 */     if (this.vote_num_timestamp != _o_.vote_num_timestamp) return false;
/*  696 */     if (this.round_robin_point != _o_.round_robin_point) return false;
/*  697 */     if (this.round_robin_win_num != _o_.round_robin_win_num) return false;
/*  698 */     if (this.round_robin_lose_num != _o_.round_robin_lose_num) return false;
/*  699 */     if (this.round_robin_end_average_fight_value != _o_.round_robin_end_average_fight_value) return false;
/*  700 */     if (!this.name.equals(_o_.name)) return false;
/*  701 */     if (this.badge != _o_.badge) return false;
/*  702 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  708 */     _xdb_verify_unsafe_();
/*  709 */     int _h_ = 0;
/*  710 */     _h_ += this.zoneid;
/*  711 */     _h_ += this.members.hashCode();
/*  712 */     _h_ = (int)(_h_ + this.vote_stage_start_average_fight_value);
/*  713 */     _h_ += this.vote_num;
/*  714 */     _h_ = (int)(_h_ + this.vote_num_timestamp);
/*  715 */     _h_ += this.round_robin_point;
/*  716 */     _h_ += this.round_robin_win_num;
/*  717 */     _h_ += this.round_robin_lose_num;
/*  718 */     _h_ = (int)(_h_ + this.round_robin_end_average_fight_value);
/*  719 */     _h_ += this.name.hashCode();
/*  720 */     _h_ += this.badge;
/*  721 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  727 */     _xdb_verify_unsafe_();
/*  728 */     StringBuilder _sb_ = new StringBuilder();
/*  729 */     _sb_.append("(");
/*  730 */     _sb_.append(this.zoneid);
/*  731 */     _sb_.append(",");
/*  732 */     _sb_.append(this.members);
/*  733 */     _sb_.append(",");
/*  734 */     _sb_.append(this.vote_stage_start_average_fight_value);
/*  735 */     _sb_.append(",");
/*  736 */     _sb_.append(this.vote_num);
/*  737 */     _sb_.append(",");
/*  738 */     _sb_.append(this.vote_num_timestamp);
/*  739 */     _sb_.append(",");
/*  740 */     _sb_.append(this.round_robin_point);
/*  741 */     _sb_.append(",");
/*  742 */     _sb_.append(this.round_robin_win_num);
/*  743 */     _sb_.append(",");
/*  744 */     _sb_.append(this.round_robin_lose_num);
/*  745 */     _sb_.append(",");
/*  746 */     _sb_.append(this.round_robin_end_average_fight_value);
/*  747 */     _sb_.append(",");
/*  748 */     _sb_.append("'").append(this.name).append("'");
/*  749 */     _sb_.append(",");
/*  750 */     _sb_.append(this.badge);
/*  751 */     _sb_.append(")");
/*  752 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  758 */     ListenableBean lb = new ListenableBean();
/*  759 */     lb.add(new ListenableChanged().setVarName("zoneid"));
/*  760 */     lb.add(new ListenableChanged().setVarName("members"));
/*  761 */     lb.add(new ListenableChanged().setVarName("vote_stage_start_average_fight_value"));
/*  762 */     lb.add(new ListenableChanged().setVarName("vote_num"));
/*  763 */     lb.add(new ListenableChanged().setVarName("vote_num_timestamp"));
/*  764 */     lb.add(new ListenableChanged().setVarName("round_robin_point"));
/*  765 */     lb.add(new ListenableChanged().setVarName("round_robin_win_num"));
/*  766 */     lb.add(new ListenableChanged().setVarName("round_robin_lose_num"));
/*  767 */     lb.add(new ListenableChanged().setVarName("round_robin_end_average_fight_value"));
/*  768 */     lb.add(new ListenableChanged().setVarName("name"));
/*  769 */     lb.add(new ListenableChanged().setVarName("badge"));
/*  770 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AttendCorpsInfo {
/*      */     private Const() {}
/*      */     
/*      */     AttendCorpsInfo nThis() {
/*  777 */       return AttendCorpsInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  783 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AttendCorpsInfo copy()
/*      */     {
/*  789 */       return AttendCorpsInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AttendCorpsInfo toData()
/*      */     {
/*  795 */       return AttendCorpsInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AttendCorpsInfo toBean()
/*      */     {
/*  800 */       return AttendCorpsInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AttendCorpsInfo toDataIf()
/*      */     {
/*  806 */       return AttendCorpsInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AttendCorpsInfo toBeanIf()
/*      */     {
/*  811 */       return AttendCorpsInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getZoneid()
/*      */     {
/*  818 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  819 */       return AttendCorpsInfo.this.zoneid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMembers()
/*      */     {
/*  826 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  827 */       return xdb.Consts.constList(AttendCorpsInfo.this.members);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getMembersAsData()
/*      */     {
/*  833 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*      */       
/*  835 */       AttendCorpsInfo _o_ = AttendCorpsInfo.this;
/*  836 */       List<Long> members = new ArrayList();
/*  837 */       members.addAll(_o_.members);
/*  838 */       return members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getVote_stage_start_average_fight_value()
/*      */     {
/*  845 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  846 */       return AttendCorpsInfo.this.vote_stage_start_average_fight_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVote_num()
/*      */     {
/*  853 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  854 */       return AttendCorpsInfo.this.vote_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVote_num_timestamp()
/*      */     {
/*  861 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  862 */       return AttendCorpsInfo.this.vote_num_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound_robin_point()
/*      */     {
/*  869 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  870 */       return AttendCorpsInfo.this.round_robin_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound_robin_win_num()
/*      */     {
/*  877 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  878 */       return AttendCorpsInfo.this.round_robin_win_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound_robin_lose_num()
/*      */     {
/*  885 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  886 */       return AttendCorpsInfo.this.round_robin_lose_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getRound_robin_end_average_fight_value()
/*      */     {
/*  893 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  894 */       return AttendCorpsInfo.this.round_robin_end_average_fight_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/*  901 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  902 */       return AttendCorpsInfo.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/*  909 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  910 */       return AttendCorpsInfo.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBadge()
/*      */     {
/*  917 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  918 */       return AttendCorpsInfo.this.badge;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setZoneid(int _v_)
/*      */     {
/*  925 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  926 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote_stage_start_average_fight_value(float _v_)
/*      */     {
/*  933 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  934 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote_num(int _v_)
/*      */     {
/*  941 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  942 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote_num_timestamp(long _v_)
/*      */     {
/*  949 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  950 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_point(int _v_)
/*      */     {
/*  957 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  958 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_win_num(int _v_)
/*      */     {
/*  965 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  966 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_lose_num(int _v_)
/*      */     {
/*  973 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  974 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_end_average_fight_value(float _v_)
/*      */     {
/*  981 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  982 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/*  989 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  990 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/*  997 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/*  998 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBadge(int _v_)
/*      */     {
/* 1005 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/* 1006 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1012 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/* 1013 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1019 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/* 1020 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1026 */       return AttendCorpsInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1032 */       return AttendCorpsInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1038 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/* 1039 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1045 */       return AttendCorpsInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1051 */       return AttendCorpsInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1057 */       AttendCorpsInfo.this._xdb_verify_unsafe_();
/* 1058 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1064 */       return AttendCorpsInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1070 */       return AttendCorpsInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1076 */       return AttendCorpsInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1082 */       return AttendCorpsInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1088 */       return AttendCorpsInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1094 */       return AttendCorpsInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1100 */       return AttendCorpsInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AttendCorpsInfo
/*      */   {
/*      */     private int zoneid;
/*      */     
/*      */     private ArrayList<Long> members;
/*      */     
/*      */     private float vote_stage_start_average_fight_value;
/*      */     
/*      */     private int vote_num;
/*      */     
/*      */     private long vote_num_timestamp;
/*      */     
/*      */     private int round_robin_point;
/*      */     
/*      */     private int round_robin_win_num;
/*      */     
/*      */     private int round_robin_lose_num;
/*      */     
/*      */     private float round_robin_end_average_fight_value;
/*      */     
/*      */     private String name;
/*      */     
/*      */     private int badge;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1132 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1137 */       this.zoneid = -1;
/* 1138 */       this.members = new ArrayList();
/* 1139 */       this.vote_stage_start_average_fight_value = 0.0F;
/* 1140 */       this.vote_num = 0;
/* 1141 */       this.vote_num_timestamp = 0L;
/* 1142 */       this.round_robin_point = 0;
/* 1143 */       this.round_robin_win_num = 0;
/* 1144 */       this.round_robin_lose_num = 0;
/* 1145 */       this.round_robin_end_average_fight_value = 0.0F;
/* 1146 */       this.name = "";
/*      */     }
/*      */     
/*      */     Data(xbean.AttendCorpsInfo _o1_)
/*      */     {
/* 1151 */       if ((_o1_ instanceof AttendCorpsInfo)) { assign((AttendCorpsInfo)_o1_);
/* 1152 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1153 */       } else if ((_o1_ instanceof AttendCorpsInfo.Const)) assign(((AttendCorpsInfo.Const)_o1_).nThis()); else {
/* 1154 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AttendCorpsInfo _o_) {
/* 1159 */       this.zoneid = _o_.zoneid;
/* 1160 */       this.members = new ArrayList();
/* 1161 */       this.members.addAll(_o_.members);
/* 1162 */       this.vote_stage_start_average_fight_value = _o_.vote_stage_start_average_fight_value;
/* 1163 */       this.vote_num = _o_.vote_num;
/* 1164 */       this.vote_num_timestamp = _o_.vote_num_timestamp;
/* 1165 */       this.round_robin_point = _o_.round_robin_point;
/* 1166 */       this.round_robin_win_num = _o_.round_robin_win_num;
/* 1167 */       this.round_robin_lose_num = _o_.round_robin_lose_num;
/* 1168 */       this.round_robin_end_average_fight_value = _o_.round_robin_end_average_fight_value;
/* 1169 */       this.name = _o_.name;
/* 1170 */       this.badge = _o_.badge;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1175 */       this.zoneid = _o_.zoneid;
/* 1176 */       this.members = new ArrayList();
/* 1177 */       this.members.addAll(_o_.members);
/* 1178 */       this.vote_stage_start_average_fight_value = _o_.vote_stage_start_average_fight_value;
/* 1179 */       this.vote_num = _o_.vote_num;
/* 1180 */       this.vote_num_timestamp = _o_.vote_num_timestamp;
/* 1181 */       this.round_robin_point = _o_.round_robin_point;
/* 1182 */       this.round_robin_win_num = _o_.round_robin_win_num;
/* 1183 */       this.round_robin_lose_num = _o_.round_robin_lose_num;
/* 1184 */       this.round_robin_end_average_fight_value = _o_.round_robin_end_average_fight_value;
/* 1185 */       this.name = _o_.name;
/* 1186 */       this.badge = _o_.badge;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1192 */       _os_.marshal(this.zoneid);
/* 1193 */       _os_.compact_uint32(this.members.size());
/* 1194 */       for (Long _v_ : this.members)
/*      */       {
/* 1196 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1198 */       _os_.marshal(this.vote_stage_start_average_fight_value);
/* 1199 */       _os_.marshal(this.vote_num);
/* 1200 */       _os_.marshal(this.vote_num_timestamp);
/* 1201 */       _os_.marshal(this.round_robin_point);
/* 1202 */       _os_.marshal(this.round_robin_win_num);
/* 1203 */       _os_.marshal(this.round_robin_lose_num);
/* 1204 */       _os_.marshal(this.round_robin_end_average_fight_value);
/* 1205 */       _os_.marshal(this.name, "UTF-16LE");
/* 1206 */       _os_.marshal(this.badge);
/* 1207 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1213 */       this.zoneid = _os_.unmarshal_int();
/* 1214 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1216 */         long _v_ = 0L;
/* 1217 */         _v_ = _os_.unmarshal_long();
/* 1218 */         this.members.add(Long.valueOf(_v_));
/*      */       }
/* 1220 */       this.vote_stage_start_average_fight_value = _os_.unmarshal_float();
/* 1221 */       this.vote_num = _os_.unmarshal_int();
/* 1222 */       this.vote_num_timestamp = _os_.unmarshal_long();
/* 1223 */       this.round_robin_point = _os_.unmarshal_int();
/* 1224 */       this.round_robin_win_num = _os_.unmarshal_int();
/* 1225 */       this.round_robin_lose_num = _os_.unmarshal_int();
/* 1226 */       this.round_robin_end_average_fight_value = _os_.unmarshal_float();
/* 1227 */       this.name = _os_.unmarshal_String("UTF-16LE");
/* 1228 */       this.badge = _os_.unmarshal_int();
/* 1229 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1235 */       int _size_ = 0;
/* 1236 */       _size_ += CodedOutputStream.computeInt32Size(1, this.zoneid);
/* 1237 */       for (Long _v_ : this.members)
/*      */       {
/* 1239 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/* 1241 */       _size_ += CodedOutputStream.computeFloatSize(3, this.vote_stage_start_average_fight_value);
/* 1242 */       _size_ += CodedOutputStream.computeInt32Size(4, this.vote_num);
/* 1243 */       _size_ += CodedOutputStream.computeInt64Size(5, this.vote_num_timestamp);
/* 1244 */       _size_ += CodedOutputStream.computeInt32Size(6, this.round_robin_point);
/* 1245 */       _size_ += CodedOutputStream.computeInt32Size(7, this.round_robin_win_num);
/* 1246 */       _size_ += CodedOutputStream.computeInt32Size(8, this.round_robin_lose_num);
/* 1247 */       _size_ += CodedOutputStream.computeFloatSize(9, this.round_robin_end_average_fight_value);
/*      */       try
/*      */       {
/* 1250 */         _size_ += CodedOutputStream.computeBytesSize(10, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1254 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1256 */       _size_ += CodedOutputStream.computeInt32Size(11, this.badge);
/* 1257 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1265 */         _output_.writeInt32(1, this.zoneid);
/* 1266 */         for (Long _v_ : this.members)
/*      */         {
/* 1268 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/* 1270 */         _output_.writeFloat(3, this.vote_stage_start_average_fight_value);
/* 1271 */         _output_.writeInt32(4, this.vote_num);
/* 1272 */         _output_.writeInt64(5, this.vote_num_timestamp);
/* 1273 */         _output_.writeInt32(6, this.round_robin_point);
/* 1274 */         _output_.writeInt32(7, this.round_robin_win_num);
/* 1275 */         _output_.writeInt32(8, this.round_robin_lose_num);
/* 1276 */         _output_.writeFloat(9, this.round_robin_end_average_fight_value);
/* 1277 */         _output_.writeBytes(10, ByteString.copyFrom(this.name, "UTF-16LE"));
/* 1278 */         _output_.writeInt32(11, this.badge);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1282 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1284 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1292 */         boolean done = false;
/* 1293 */         while (!done)
/*      */         {
/* 1295 */           int tag = _input_.readTag();
/* 1296 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1300 */             done = true;
/* 1301 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1305 */             this.zoneid = _input_.readInt32();
/* 1306 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1310 */             long _v_ = 0L;
/* 1311 */             _v_ = _input_.readInt64();
/* 1312 */             this.members.add(Long.valueOf(_v_));
/* 1313 */             break;
/*      */           
/*      */ 
/*      */           case 29: 
/* 1317 */             this.vote_stage_start_average_fight_value = _input_.readFloat();
/* 1318 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1322 */             this.vote_num = _input_.readInt32();
/* 1323 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1327 */             this.vote_num_timestamp = _input_.readInt64();
/* 1328 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1332 */             this.round_robin_point = _input_.readInt32();
/* 1333 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1337 */             this.round_robin_win_num = _input_.readInt32();
/* 1338 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1342 */             this.round_robin_lose_num = _input_.readInt32();
/* 1343 */             break;
/*      */           
/*      */ 
/*      */           case 77: 
/* 1347 */             this.round_robin_end_average_fight_value = _input_.readFloat();
/* 1348 */             break;
/*      */           
/*      */ 
/*      */           case 82: 
/* 1352 */             this.name = _input_.readBytes().toString("UTF-16LE");
/* 1353 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1357 */             this.badge = _input_.readInt32();
/* 1358 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1362 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1364 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1373 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1377 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1379 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AttendCorpsInfo copy()
/*      */     {
/* 1385 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AttendCorpsInfo toData()
/*      */     {
/* 1391 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AttendCorpsInfo toBean()
/*      */     {
/* 1396 */       return new AttendCorpsInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AttendCorpsInfo toDataIf()
/*      */     {
/* 1402 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AttendCorpsInfo toBeanIf()
/*      */     {
/* 1407 */       return new AttendCorpsInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1413 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1417 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1421 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1425 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1429 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1433 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1437 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getZoneid()
/*      */     {
/* 1444 */       return this.zoneid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMembers()
/*      */     {
/* 1451 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMembersAsData()
/*      */     {
/* 1458 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getVote_stage_start_average_fight_value()
/*      */     {
/* 1465 */       return this.vote_stage_start_average_fight_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVote_num()
/*      */     {
/* 1472 */       return this.vote_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVote_num_timestamp()
/*      */     {
/* 1479 */       return this.vote_num_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound_robin_point()
/*      */     {
/* 1486 */       return this.round_robin_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound_robin_win_num()
/*      */     {
/* 1493 */       return this.round_robin_win_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound_robin_lose_num()
/*      */     {
/* 1500 */       return this.round_robin_lose_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getRound_robin_end_average_fight_value()
/*      */     {
/* 1507 */       return this.round_robin_end_average_fight_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1514 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1521 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBadge()
/*      */     {
/* 1528 */       return this.badge;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setZoneid(int _v_)
/*      */     {
/* 1535 */       this.zoneid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote_stage_start_average_fight_value(float _v_)
/*      */     {
/* 1542 */       this.vote_stage_start_average_fight_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote_num(int _v_)
/*      */     {
/* 1549 */       this.vote_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote_num_timestamp(long _v_)
/*      */     {
/* 1556 */       this.vote_num_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_point(int _v_)
/*      */     {
/* 1563 */       this.round_robin_point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_win_num(int _v_)
/*      */     {
/* 1570 */       this.round_robin_win_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_lose_num(int _v_)
/*      */     {
/* 1577 */       this.round_robin_lose_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_robin_end_average_fight_value(float _v_)
/*      */     {
/* 1584 */       this.round_robin_end_average_fight_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1591 */       if (null == _v_)
/* 1592 */         throw new NullPointerException();
/* 1593 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1600 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBadge(int _v_)
/*      */     {
/* 1607 */       this.badge = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1613 */       if (!(_o1_ instanceof Data)) return false;
/* 1614 */       Data _o_ = (Data)_o1_;
/* 1615 */       if (this.zoneid != _o_.zoneid) return false;
/* 1616 */       if (!this.members.equals(_o_.members)) return false;
/* 1617 */       if (this.vote_stage_start_average_fight_value != _o_.vote_stage_start_average_fight_value) return false;
/* 1618 */       if (this.vote_num != _o_.vote_num) return false;
/* 1619 */       if (this.vote_num_timestamp != _o_.vote_num_timestamp) return false;
/* 1620 */       if (this.round_robin_point != _o_.round_robin_point) return false;
/* 1621 */       if (this.round_robin_win_num != _o_.round_robin_win_num) return false;
/* 1622 */       if (this.round_robin_lose_num != _o_.round_robin_lose_num) return false;
/* 1623 */       if (this.round_robin_end_average_fight_value != _o_.round_robin_end_average_fight_value) return false;
/* 1624 */       if (!this.name.equals(_o_.name)) return false;
/* 1625 */       if (this.badge != _o_.badge) return false;
/* 1626 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1632 */       int _h_ = 0;
/* 1633 */       _h_ += this.zoneid;
/* 1634 */       _h_ += this.members.hashCode();
/* 1635 */       _h_ = (int)(_h_ + this.vote_stage_start_average_fight_value);
/* 1636 */       _h_ += this.vote_num;
/* 1637 */       _h_ = (int)(_h_ + this.vote_num_timestamp);
/* 1638 */       _h_ += this.round_robin_point;
/* 1639 */       _h_ += this.round_robin_win_num;
/* 1640 */       _h_ += this.round_robin_lose_num;
/* 1641 */       _h_ = (int)(_h_ + this.round_robin_end_average_fight_value);
/* 1642 */       _h_ += this.name.hashCode();
/* 1643 */       _h_ += this.badge;
/* 1644 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1650 */       StringBuilder _sb_ = new StringBuilder();
/* 1651 */       _sb_.append("(");
/* 1652 */       _sb_.append(this.zoneid);
/* 1653 */       _sb_.append(",");
/* 1654 */       _sb_.append(this.members);
/* 1655 */       _sb_.append(",");
/* 1656 */       _sb_.append(this.vote_stage_start_average_fight_value);
/* 1657 */       _sb_.append(",");
/* 1658 */       _sb_.append(this.vote_num);
/* 1659 */       _sb_.append(",");
/* 1660 */       _sb_.append(this.vote_num_timestamp);
/* 1661 */       _sb_.append(",");
/* 1662 */       _sb_.append(this.round_robin_point);
/* 1663 */       _sb_.append(",");
/* 1664 */       _sb_.append(this.round_robin_win_num);
/* 1665 */       _sb_.append(",");
/* 1666 */       _sb_.append(this.round_robin_lose_num);
/* 1667 */       _sb_.append(",");
/* 1668 */       _sb_.append(this.round_robin_end_average_fight_value);
/* 1669 */       _sb_.append(",");
/* 1670 */       _sb_.append("'").append(this.name).append("'");
/* 1671 */       _sb_.append(",");
/* 1672 */       _sb_.append(this.badge);
/* 1673 */       _sb_.append(")");
/* 1674 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AttendCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */