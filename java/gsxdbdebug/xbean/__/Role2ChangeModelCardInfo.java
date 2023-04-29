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
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class Role2ChangeModelCardInfo extends XBean implements xbean.Role2ChangeModelCardInfo
/*      */ {
/*      */   private ArrayList<Long> card_ids;
/*      */   private int current_card_cfg_id;
/*      */   private int current_card_level;
/*      */   private boolean visible;
/*      */   private int fight_count;
/*      */   private long start_time;
/*      */   private int overlay_count;
/*      */   private long next_card_id;
/*      */   private HashMap<Long, xbean.ChangeModelCardInfo> cardid2info;
/*      */   private boolean activated_in_fight;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   36 */     this.card_ids.clear();
/*   37 */     this.current_card_cfg_id = 0;
/*   38 */     this.current_card_level = 0;
/*   39 */     this.visible = true;
/*   40 */     this.fight_count = 0;
/*   41 */     this.start_time = 0L;
/*   42 */     this.overlay_count = 0;
/*   43 */     this.next_card_id = 1L;
/*   44 */     this.cardid2info.clear();
/*   45 */     this.activated_in_fight = false;
/*      */   }
/*      */   
/*      */   Role2ChangeModelCardInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     this.card_ids = new ArrayList();
/*   52 */     this.visible = true;
/*   53 */     this.next_card_id = 1L;
/*   54 */     this.cardid2info = new HashMap();
/*   55 */     this.activated_in_fight = false;
/*      */   }
/*      */   
/*      */   public Role2ChangeModelCardInfo()
/*      */   {
/*   60 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2ChangeModelCardInfo(Role2ChangeModelCardInfo _o_)
/*      */   {
/*   65 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2ChangeModelCardInfo(xbean.Role2ChangeModelCardInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   70 */     super(_xp_, _vn_);
/*   71 */     if ((_o1_ instanceof Role2ChangeModelCardInfo)) { assign((Role2ChangeModelCardInfo)_o1_);
/*   72 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   73 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   74 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2ChangeModelCardInfo _o_) {
/*   79 */     _o_._xdb_verify_unsafe_();
/*   80 */     this.card_ids = new ArrayList();
/*   81 */     this.card_ids.addAll(_o_.card_ids);
/*   82 */     this.current_card_cfg_id = _o_.current_card_cfg_id;
/*   83 */     this.current_card_level = _o_.current_card_level;
/*   84 */     this.visible = _o_.visible;
/*   85 */     this.fight_count = _o_.fight_count;
/*   86 */     this.start_time = _o_.start_time;
/*   87 */     this.overlay_count = _o_.overlay_count;
/*   88 */     this.next_card_id = _o_.next_card_id;
/*   89 */     this.cardid2info = new HashMap();
/*   90 */     for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : _o_.cardid2info.entrySet())
/*   91 */       this.cardid2info.put(_e_.getKey(), new ChangeModelCardInfo((xbean.ChangeModelCardInfo)_e_.getValue(), this, "cardid2info"));
/*   92 */     this.activated_in_fight = _o_.activated_in_fight;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   97 */     this.card_ids = new ArrayList();
/*   98 */     this.card_ids.addAll(_o_.card_ids);
/*   99 */     this.current_card_cfg_id = _o_.current_card_cfg_id;
/*  100 */     this.current_card_level = _o_.current_card_level;
/*  101 */     this.visible = _o_.visible;
/*  102 */     this.fight_count = _o_.fight_count;
/*  103 */     this.start_time = _o_.start_time;
/*  104 */     this.overlay_count = _o_.overlay_count;
/*  105 */     this.next_card_id = _o_.next_card_id;
/*  106 */     this.cardid2info = new HashMap();
/*  107 */     for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : _o_.cardid2info.entrySet())
/*  108 */       this.cardid2info.put(_e_.getKey(), new ChangeModelCardInfo((xbean.ChangeModelCardInfo)_e_.getValue(), this, "cardid2info"));
/*  109 */     this.activated_in_fight = _o_.activated_in_fight;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  115 */     _xdb_verify_unsafe_();
/*  116 */     _os_.compact_uint32(this.card_ids.size());
/*  117 */     for (Long _v_ : this.card_ids)
/*      */     {
/*  119 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  121 */     _os_.marshal(this.current_card_cfg_id);
/*  122 */     _os_.marshal(this.current_card_level);
/*  123 */     _os_.marshal(this.visible);
/*  124 */     _os_.marshal(this.fight_count);
/*  125 */     _os_.marshal(this.start_time);
/*  126 */     _os_.marshal(this.overlay_count);
/*  127 */     _os_.marshal(this.next_card_id);
/*  128 */     _os_.compact_uint32(this.cardid2info.size());
/*  129 */     for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : this.cardid2info.entrySet())
/*      */     {
/*  131 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  132 */       ((xbean.ChangeModelCardInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  134 */     _os_.marshal(this.activated_in_fight);
/*  135 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*  142 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  144 */       long _v_ = 0L;
/*  145 */       _v_ = _os_.unmarshal_long();
/*  146 */       this.card_ids.add(Long.valueOf(_v_));
/*      */     }
/*  148 */     this.current_card_cfg_id = _os_.unmarshal_int();
/*  149 */     this.current_card_level = _os_.unmarshal_int();
/*  150 */     this.visible = _os_.unmarshal_boolean();
/*  151 */     this.fight_count = _os_.unmarshal_int();
/*  152 */     this.start_time = _os_.unmarshal_long();
/*  153 */     this.overlay_count = _os_.unmarshal_int();
/*  154 */     this.next_card_id = _os_.unmarshal_long();
/*      */     
/*  156 */     int size = _os_.uncompact_uint32();
/*  157 */     if (size >= 12)
/*      */     {
/*  159 */       this.cardid2info = new HashMap(size * 2);
/*      */     }
/*  161 */     for (; size > 0; size--)
/*      */     {
/*  163 */       long _k_ = 0L;
/*  164 */       _k_ = _os_.unmarshal_long();
/*  165 */       xbean.ChangeModelCardInfo _v_ = new ChangeModelCardInfo(0, this, "cardid2info");
/*  166 */       _v_.unmarshal(_os_);
/*  167 */       this.cardid2info.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  170 */     this.activated_in_fight = _os_.unmarshal_boolean();
/*  171 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  177 */     _xdb_verify_unsafe_();
/*  178 */     int _size_ = 0;
/*  179 */     for (Long _v_ : this.card_ids)
/*      */     {
/*  181 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */     }
/*  183 */     _size_ += CodedOutputStream.computeInt32Size(2, this.current_card_cfg_id);
/*  184 */     _size_ += CodedOutputStream.computeInt32Size(3, this.current_card_level);
/*  185 */     _size_ += CodedOutputStream.computeBoolSize(4, this.visible);
/*  186 */     _size_ += CodedOutputStream.computeInt32Size(5, this.fight_count);
/*  187 */     _size_ += CodedOutputStream.computeInt64Size(6, this.start_time);
/*  188 */     _size_ += CodedOutputStream.computeInt32Size(7, this.overlay_count);
/*  189 */     _size_ += CodedOutputStream.computeInt64Size(8, this.next_card_id);
/*  190 */     for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : this.cardid2info.entrySet())
/*      */     {
/*  192 */       _size_ += CodedOutputStream.computeInt64Size(9, ((Long)_e_.getKey()).longValue());
/*  193 */       _size_ += CodedOutputStream.computeMessageSize(9, (ppbio.Message)_e_.getValue());
/*      */     }
/*  195 */     _size_ += CodedOutputStream.computeBoolSize(10, this.activated_in_fight);
/*  196 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  202 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  205 */       for (Long _v_ : this.card_ids)
/*      */       {
/*  207 */         _output_.writeInt64(1, _v_.longValue());
/*      */       }
/*  209 */       _output_.writeInt32(2, this.current_card_cfg_id);
/*  210 */       _output_.writeInt32(3, this.current_card_level);
/*  211 */       _output_.writeBool(4, this.visible);
/*  212 */       _output_.writeInt32(5, this.fight_count);
/*  213 */       _output_.writeInt64(6, this.start_time);
/*  214 */       _output_.writeInt32(7, this.overlay_count);
/*  215 */       _output_.writeInt64(8, this.next_card_id);
/*  216 */       for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : this.cardid2info.entrySet())
/*      */       {
/*  218 */         _output_.writeInt64(9, ((Long)_e_.getKey()).longValue());
/*  219 */         _output_.writeMessage(9, (ppbio.Message)_e_.getValue());
/*      */       }
/*  221 */       _output_.writeBool(10, this.activated_in_fight);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  225 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  227 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  236 */       boolean done = false;
/*  237 */       while (!done)
/*      */       {
/*  239 */         int tag = _input_.readTag();
/*  240 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  244 */           done = true;
/*  245 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  249 */           long _v_ = 0L;
/*  250 */           _v_ = _input_.readInt64();
/*  251 */           this.card_ids.add(Long.valueOf(_v_));
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  256 */           this.current_card_cfg_id = _input_.readInt32();
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  261 */           this.current_card_level = _input_.readInt32();
/*  262 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  266 */           this.visible = _input_.readBool();
/*  267 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  271 */           this.fight_count = _input_.readInt32();
/*  272 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  276 */           this.start_time = _input_.readInt64();
/*  277 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  281 */           this.overlay_count = _input_.readInt32();
/*  282 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  286 */           this.next_card_id = _input_.readInt64();
/*  287 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  291 */           long _k_ = 0L;
/*  292 */           _k_ = _input_.readInt64();
/*  293 */           int readTag = _input_.readTag();
/*  294 */           if (74 != readTag)
/*      */           {
/*  296 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  298 */           xbean.ChangeModelCardInfo _v_ = new ChangeModelCardInfo(0, this, "cardid2info");
/*  299 */           _input_.readMessage(_v_);
/*  300 */           this.cardid2info.put(Long.valueOf(_k_), _v_);
/*  301 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  305 */           this.activated_in_fight = _input_.readBool();
/*  306 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  310 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  312 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  321 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  325 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  327 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChangeModelCardInfo copy()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*  334 */     return new Role2ChangeModelCardInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChangeModelCardInfo toData()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2ChangeModelCardInfo toBean()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     return new Role2ChangeModelCardInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChangeModelCardInfo toDataIf()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2ChangeModelCardInfo toBeanIf()
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getCard_ids()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return Logs.logList(new LogKey(this, "card_ids"), this.card_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getCard_idsAsData()
/*      */   {
/*  381 */     _xdb_verify_unsafe_();
/*      */     
/*  383 */     Role2ChangeModelCardInfo _o_ = this;
/*  384 */     List<Long> card_ids = new ArrayList();
/*  385 */     card_ids.addAll(_o_.card_ids);
/*  386 */     return card_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_card_cfg_id()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return this.current_card_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_card_level()
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     return this.current_card_level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getVisible()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return this.visible;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFight_count()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     return this.fight_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStart_time()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     return this.start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOverlay_count()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     return this.overlay_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getNext_card_id()
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     return this.next_card_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ChangeModelCardInfo> getCardid2info()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     return Logs.logMap(new LogKey(this, "cardid2info"), this.cardid2info);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ChangeModelCardInfo> getCardid2infoAsData()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*      */     
/*  459 */     Role2ChangeModelCardInfo _o_ = this;
/*  460 */     Map<Long, xbean.ChangeModelCardInfo> cardid2info = new HashMap();
/*  461 */     for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : _o_.cardid2info.entrySet())
/*  462 */       cardid2info.put(_e_.getKey(), new ChangeModelCardInfo.Data((xbean.ChangeModelCardInfo)_e_.getValue()));
/*  463 */     return cardid2info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getActivated_in_fight()
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*  471 */     return this.activated_in_fight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_card_cfg_id(int _v_)
/*      */   {
/*  478 */     _xdb_verify_unsafe_();
/*  479 */     Logs.logIf(new LogKey(this, "current_card_cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  483 */         new LogInt(this, Role2ChangeModelCardInfo.this.current_card_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  487 */             Role2ChangeModelCardInfo.this.current_card_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  491 */     });
/*  492 */     this.current_card_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_card_level(int _v_)
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     Logs.logIf(new LogKey(this, "current_card_level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  504 */         new LogInt(this, Role2ChangeModelCardInfo.this.current_card_level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  508 */             Role2ChangeModelCardInfo.this.current_card_level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  512 */     });
/*  513 */     this.current_card_level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVisible(boolean _v_)
/*      */   {
/*  520 */     _xdb_verify_unsafe_();
/*  521 */     Logs.logIf(new LogKey(this, "visible")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  525 */         new xdb.logs.LogObject(this, Boolean.valueOf(Role2ChangeModelCardInfo.this.visible))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  529 */             Role2ChangeModelCardInfo.this.visible = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  533 */     });
/*  534 */     this.visible = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFight_count(int _v_)
/*      */   {
/*  541 */     _xdb_verify_unsafe_();
/*  542 */     Logs.logIf(new LogKey(this, "fight_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  546 */         new LogInt(this, Role2ChangeModelCardInfo.this.fight_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  550 */             Role2ChangeModelCardInfo.this.fight_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  554 */     });
/*  555 */     this.fight_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStart_time(long _v_)
/*      */   {
/*  562 */     _xdb_verify_unsafe_();
/*  563 */     Logs.logIf(new LogKey(this, "start_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  567 */         new xdb.logs.LogLong(this, Role2ChangeModelCardInfo.this.start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  571 */             Role2ChangeModelCardInfo.this.start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  575 */     });
/*  576 */     this.start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOverlay_count(int _v_)
/*      */   {
/*  583 */     _xdb_verify_unsafe_();
/*  584 */     Logs.logIf(new LogKey(this, "overlay_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  588 */         new LogInt(this, Role2ChangeModelCardInfo.this.overlay_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  592 */             Role2ChangeModelCardInfo.this.overlay_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  596 */     });
/*  597 */     this.overlay_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNext_card_id(long _v_)
/*      */   {
/*  604 */     _xdb_verify_unsafe_();
/*  605 */     Logs.logIf(new LogKey(this, "next_card_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  609 */         new xdb.logs.LogLong(this, Role2ChangeModelCardInfo.this.next_card_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  613 */             Role2ChangeModelCardInfo.this.next_card_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  617 */     });
/*  618 */     this.next_card_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivated_in_fight(boolean _v_)
/*      */   {
/*  625 */     _xdb_verify_unsafe_();
/*  626 */     Logs.logIf(new LogKey(this, "activated_in_fight")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  630 */         new xdb.logs.LogObject(this, Boolean.valueOf(Role2ChangeModelCardInfo.this.activated_in_fight))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  634 */             Role2ChangeModelCardInfo.this.activated_in_fight = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  638 */     });
/*  639 */     this.activated_in_fight = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  645 */     _xdb_verify_unsafe_();
/*  646 */     Role2ChangeModelCardInfo _o_ = null;
/*  647 */     if ((_o1_ instanceof Role2ChangeModelCardInfo)) { _o_ = (Role2ChangeModelCardInfo)_o1_;
/*  648 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  649 */       return false;
/*  650 */     if (!this.card_ids.equals(_o_.card_ids)) return false;
/*  651 */     if (this.current_card_cfg_id != _o_.current_card_cfg_id) return false;
/*  652 */     if (this.current_card_level != _o_.current_card_level) return false;
/*  653 */     if (this.visible != _o_.visible) return false;
/*  654 */     if (this.fight_count != _o_.fight_count) return false;
/*  655 */     if (this.start_time != _o_.start_time) return false;
/*  656 */     if (this.overlay_count != _o_.overlay_count) return false;
/*  657 */     if (this.next_card_id != _o_.next_card_id) return false;
/*  658 */     if (!this.cardid2info.equals(_o_.cardid2info)) return false;
/*  659 */     if (this.activated_in_fight != _o_.activated_in_fight) return false;
/*  660 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  666 */     _xdb_verify_unsafe_();
/*  667 */     int _h_ = 0;
/*  668 */     _h_ += this.card_ids.hashCode();
/*  669 */     _h_ += this.current_card_cfg_id;
/*  670 */     _h_ += this.current_card_level;
/*  671 */     _h_ += (this.visible ? 1231 : 1237);
/*  672 */     _h_ += this.fight_count;
/*  673 */     _h_ = (int)(_h_ + this.start_time);
/*  674 */     _h_ += this.overlay_count;
/*  675 */     _h_ = (int)(_h_ + this.next_card_id);
/*  676 */     _h_ += this.cardid2info.hashCode();
/*  677 */     _h_ += (this.activated_in_fight ? 1231 : 1237);
/*  678 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  684 */     _xdb_verify_unsafe_();
/*  685 */     StringBuilder _sb_ = new StringBuilder();
/*  686 */     _sb_.append("(");
/*  687 */     _sb_.append(this.card_ids);
/*  688 */     _sb_.append(",");
/*  689 */     _sb_.append(this.current_card_cfg_id);
/*  690 */     _sb_.append(",");
/*  691 */     _sb_.append(this.current_card_level);
/*  692 */     _sb_.append(",");
/*  693 */     _sb_.append(this.visible);
/*  694 */     _sb_.append(",");
/*  695 */     _sb_.append(this.fight_count);
/*  696 */     _sb_.append(",");
/*  697 */     _sb_.append(this.start_time);
/*  698 */     _sb_.append(",");
/*  699 */     _sb_.append(this.overlay_count);
/*  700 */     _sb_.append(",");
/*  701 */     _sb_.append(this.next_card_id);
/*  702 */     _sb_.append(",");
/*  703 */     _sb_.append(this.cardid2info);
/*  704 */     _sb_.append(",");
/*  705 */     _sb_.append(this.activated_in_fight);
/*  706 */     _sb_.append(")");
/*  707 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  713 */     ListenableBean lb = new ListenableBean();
/*  714 */     lb.add(new ListenableChanged().setVarName("card_ids"));
/*  715 */     lb.add(new ListenableChanged().setVarName("current_card_cfg_id"));
/*  716 */     lb.add(new ListenableChanged().setVarName("current_card_level"));
/*  717 */     lb.add(new ListenableChanged().setVarName("visible"));
/*  718 */     lb.add(new ListenableChanged().setVarName("fight_count"));
/*  719 */     lb.add(new ListenableChanged().setVarName("start_time"));
/*  720 */     lb.add(new ListenableChanged().setVarName("overlay_count"));
/*  721 */     lb.add(new ListenableChanged().setVarName("next_card_id"));
/*  722 */     lb.add(new xdb.logs.ListenableMap().setVarName("cardid2info"));
/*  723 */     lb.add(new ListenableChanged().setVarName("activated_in_fight"));
/*  724 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2ChangeModelCardInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2ChangeModelCardInfo nThis() {
/*  731 */       return Role2ChangeModelCardInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  737 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChangeModelCardInfo copy()
/*      */     {
/*  743 */       return Role2ChangeModelCardInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChangeModelCardInfo toData()
/*      */     {
/*  749 */       return Role2ChangeModelCardInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2ChangeModelCardInfo toBean()
/*      */     {
/*  754 */       return Role2ChangeModelCardInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChangeModelCardInfo toDataIf()
/*      */     {
/*  760 */       return Role2ChangeModelCardInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2ChangeModelCardInfo toBeanIf()
/*      */     {
/*  765 */       return Role2ChangeModelCardInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getCard_ids()
/*      */     {
/*  772 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  773 */       return xdb.Consts.constList(Role2ChangeModelCardInfo.this.card_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getCard_idsAsData()
/*      */     {
/*  779 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*      */       
/*  781 */       Role2ChangeModelCardInfo _o_ = Role2ChangeModelCardInfo.this;
/*  782 */       List<Long> card_ids = new ArrayList();
/*  783 */       card_ids.addAll(_o_.card_ids);
/*  784 */       return card_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_card_cfg_id()
/*      */     {
/*  791 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  792 */       return Role2ChangeModelCardInfo.this.current_card_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_card_level()
/*      */     {
/*  799 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  800 */       return Role2ChangeModelCardInfo.this.current_card_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getVisible()
/*      */     {
/*  807 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  808 */       return Role2ChangeModelCardInfo.this.visible;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFight_count()
/*      */     {
/*  815 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  816 */       return Role2ChangeModelCardInfo.this.fight_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/*  823 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  824 */       return Role2ChangeModelCardInfo.this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOverlay_count()
/*      */     {
/*  831 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  832 */       return Role2ChangeModelCardInfo.this.overlay_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNext_card_id()
/*      */     {
/*  839 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  840 */       return Role2ChangeModelCardInfo.this.next_card_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChangeModelCardInfo> getCardid2info()
/*      */     {
/*  847 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  848 */       return xdb.Consts.constMap(Role2ChangeModelCardInfo.this.cardid2info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChangeModelCardInfo> getCardid2infoAsData()
/*      */     {
/*  855 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*      */       
/*  857 */       Role2ChangeModelCardInfo _o_ = Role2ChangeModelCardInfo.this;
/*  858 */       Map<Long, xbean.ChangeModelCardInfo> cardid2info = new HashMap();
/*  859 */       for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : _o_.cardid2info.entrySet())
/*  860 */         cardid2info.put(_e_.getKey(), new ChangeModelCardInfo.Data((xbean.ChangeModelCardInfo)_e_.getValue()));
/*  861 */       return cardid2info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getActivated_in_fight()
/*      */     {
/*  868 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  869 */       return Role2ChangeModelCardInfo.this.activated_in_fight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_card_cfg_id(int _v_)
/*      */     {
/*  876 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  877 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_card_level(int _v_)
/*      */     {
/*  884 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  885 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVisible(boolean _v_)
/*      */     {
/*  892 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  893 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_count(int _v_)
/*      */     {
/*  900 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  901 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/*  908 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  909 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOverlay_count(int _v_)
/*      */     {
/*  916 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  917 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNext_card_id(long _v_)
/*      */     {
/*  924 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  925 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivated_in_fight(boolean _v_)
/*      */     {
/*  932 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  939 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  940 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  946 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  947 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  953 */       return Role2ChangeModelCardInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  959 */       return Role2ChangeModelCardInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  965 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  966 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  972 */       return Role2ChangeModelCardInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  978 */       return Role2ChangeModelCardInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  984 */       Role2ChangeModelCardInfo.this._xdb_verify_unsafe_();
/*  985 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  991 */       return Role2ChangeModelCardInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  997 */       return Role2ChangeModelCardInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1003 */       return Role2ChangeModelCardInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1009 */       return Role2ChangeModelCardInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1015 */       return Role2ChangeModelCardInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1021 */       return Role2ChangeModelCardInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1027 */       return Role2ChangeModelCardInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2ChangeModelCardInfo
/*      */   {
/*      */     private ArrayList<Long> card_ids;
/*      */     
/*      */     private int current_card_cfg_id;
/*      */     
/*      */     private int current_card_level;
/*      */     
/*      */     private boolean visible;
/*      */     
/*      */     private int fight_count;
/*      */     
/*      */     private long start_time;
/*      */     
/*      */     private int overlay_count;
/*      */     
/*      */     private long next_card_id;
/*      */     
/*      */     private HashMap<Long, xbean.ChangeModelCardInfo> cardid2info;
/*      */     
/*      */     private boolean activated_in_fight;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1057 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1062 */       this.card_ids = new ArrayList();
/* 1063 */       this.visible = true;
/* 1064 */       this.next_card_id = 1L;
/* 1065 */       this.cardid2info = new HashMap();
/* 1066 */       this.activated_in_fight = false;
/*      */     }
/*      */     
/*      */     Data(xbean.Role2ChangeModelCardInfo _o1_)
/*      */     {
/* 1071 */       if ((_o1_ instanceof Role2ChangeModelCardInfo)) { assign((Role2ChangeModelCardInfo)_o1_);
/* 1072 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1073 */       } else if ((_o1_ instanceof Role2ChangeModelCardInfo.Const)) assign(((Role2ChangeModelCardInfo.Const)_o1_).nThis()); else {
/* 1074 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2ChangeModelCardInfo _o_) {
/* 1079 */       this.card_ids = new ArrayList();
/* 1080 */       this.card_ids.addAll(_o_.card_ids);
/* 1081 */       this.current_card_cfg_id = _o_.current_card_cfg_id;
/* 1082 */       this.current_card_level = _o_.current_card_level;
/* 1083 */       this.visible = _o_.visible;
/* 1084 */       this.fight_count = _o_.fight_count;
/* 1085 */       this.start_time = _o_.start_time;
/* 1086 */       this.overlay_count = _o_.overlay_count;
/* 1087 */       this.next_card_id = _o_.next_card_id;
/* 1088 */       this.cardid2info = new HashMap();
/* 1089 */       for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : _o_.cardid2info.entrySet())
/* 1090 */         this.cardid2info.put(_e_.getKey(), new ChangeModelCardInfo.Data((xbean.ChangeModelCardInfo)_e_.getValue()));
/* 1091 */       this.activated_in_fight = _o_.activated_in_fight;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1096 */       this.card_ids = new ArrayList();
/* 1097 */       this.card_ids.addAll(_o_.card_ids);
/* 1098 */       this.current_card_cfg_id = _o_.current_card_cfg_id;
/* 1099 */       this.current_card_level = _o_.current_card_level;
/* 1100 */       this.visible = _o_.visible;
/* 1101 */       this.fight_count = _o_.fight_count;
/* 1102 */       this.start_time = _o_.start_time;
/* 1103 */       this.overlay_count = _o_.overlay_count;
/* 1104 */       this.next_card_id = _o_.next_card_id;
/* 1105 */       this.cardid2info = new HashMap();
/* 1106 */       for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : _o_.cardid2info.entrySet())
/* 1107 */         this.cardid2info.put(_e_.getKey(), new ChangeModelCardInfo.Data((xbean.ChangeModelCardInfo)_e_.getValue()));
/* 1108 */       this.activated_in_fight = _o_.activated_in_fight;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1114 */       _os_.compact_uint32(this.card_ids.size());
/* 1115 */       for (Long _v_ : this.card_ids)
/*      */       {
/* 1117 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1119 */       _os_.marshal(this.current_card_cfg_id);
/* 1120 */       _os_.marshal(this.current_card_level);
/* 1121 */       _os_.marshal(this.visible);
/* 1122 */       _os_.marshal(this.fight_count);
/* 1123 */       _os_.marshal(this.start_time);
/* 1124 */       _os_.marshal(this.overlay_count);
/* 1125 */       _os_.marshal(this.next_card_id);
/* 1126 */       _os_.compact_uint32(this.cardid2info.size());
/* 1127 */       for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : this.cardid2info.entrySet())
/*      */       {
/* 1129 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1130 */         ((xbean.ChangeModelCardInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1132 */       _os_.marshal(this.activated_in_fight);
/* 1133 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1139 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1141 */         long _v_ = 0L;
/* 1142 */         _v_ = _os_.unmarshal_long();
/* 1143 */         this.card_ids.add(Long.valueOf(_v_));
/*      */       }
/* 1145 */       this.current_card_cfg_id = _os_.unmarshal_int();
/* 1146 */       this.current_card_level = _os_.unmarshal_int();
/* 1147 */       this.visible = _os_.unmarshal_boolean();
/* 1148 */       this.fight_count = _os_.unmarshal_int();
/* 1149 */       this.start_time = _os_.unmarshal_long();
/* 1150 */       this.overlay_count = _os_.unmarshal_int();
/* 1151 */       this.next_card_id = _os_.unmarshal_long();
/*      */       
/* 1153 */       int size = _os_.uncompact_uint32();
/* 1154 */       if (size >= 12)
/*      */       {
/* 1156 */         this.cardid2info = new HashMap(size * 2);
/*      */       }
/* 1158 */       for (; size > 0; size--)
/*      */       {
/* 1160 */         long _k_ = 0L;
/* 1161 */         _k_ = _os_.unmarshal_long();
/* 1162 */         xbean.ChangeModelCardInfo _v_ = xbean.Pod.newChangeModelCardInfoData();
/* 1163 */         _v_.unmarshal(_os_);
/* 1164 */         this.cardid2info.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1167 */       this.activated_in_fight = _os_.unmarshal_boolean();
/* 1168 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1174 */       int _size_ = 0;
/* 1175 */       for (Long _v_ : this.card_ids)
/*      */       {
/* 1177 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */       }
/* 1179 */       _size_ += CodedOutputStream.computeInt32Size(2, this.current_card_cfg_id);
/* 1180 */       _size_ += CodedOutputStream.computeInt32Size(3, this.current_card_level);
/* 1181 */       _size_ += CodedOutputStream.computeBoolSize(4, this.visible);
/* 1182 */       _size_ += CodedOutputStream.computeInt32Size(5, this.fight_count);
/* 1183 */       _size_ += CodedOutputStream.computeInt64Size(6, this.start_time);
/* 1184 */       _size_ += CodedOutputStream.computeInt32Size(7, this.overlay_count);
/* 1185 */       _size_ += CodedOutputStream.computeInt64Size(8, this.next_card_id);
/* 1186 */       for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : this.cardid2info.entrySet())
/*      */       {
/* 1188 */         _size_ += CodedOutputStream.computeInt64Size(9, ((Long)_e_.getKey()).longValue());
/* 1189 */         _size_ += CodedOutputStream.computeMessageSize(9, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1191 */       _size_ += CodedOutputStream.computeBoolSize(10, this.activated_in_fight);
/* 1192 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1200 */         for (Long _v_ : this.card_ids)
/*      */         {
/* 1202 */           _output_.writeInt64(1, _v_.longValue());
/*      */         }
/* 1204 */         _output_.writeInt32(2, this.current_card_cfg_id);
/* 1205 */         _output_.writeInt32(3, this.current_card_level);
/* 1206 */         _output_.writeBool(4, this.visible);
/* 1207 */         _output_.writeInt32(5, this.fight_count);
/* 1208 */         _output_.writeInt64(6, this.start_time);
/* 1209 */         _output_.writeInt32(7, this.overlay_count);
/* 1210 */         _output_.writeInt64(8, this.next_card_id);
/* 1211 */         for (Map.Entry<Long, xbean.ChangeModelCardInfo> _e_ : this.cardid2info.entrySet())
/*      */         {
/* 1213 */           _output_.writeInt64(9, ((Long)_e_.getKey()).longValue());
/* 1214 */           _output_.writeMessage(9, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1216 */         _output_.writeBool(10, this.activated_in_fight);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1220 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1222 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1230 */         boolean done = false;
/* 1231 */         while (!done)
/*      */         {
/* 1233 */           int tag = _input_.readTag();
/* 1234 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1238 */             done = true;
/* 1239 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1243 */             long _v_ = 0L;
/* 1244 */             _v_ = _input_.readInt64();
/* 1245 */             this.card_ids.add(Long.valueOf(_v_));
/* 1246 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1250 */             this.current_card_cfg_id = _input_.readInt32();
/* 1251 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1255 */             this.current_card_level = _input_.readInt32();
/* 1256 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1260 */             this.visible = _input_.readBool();
/* 1261 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1265 */             this.fight_count = _input_.readInt32();
/* 1266 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1270 */             this.start_time = _input_.readInt64();
/* 1271 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1275 */             this.overlay_count = _input_.readInt32();
/* 1276 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1280 */             this.next_card_id = _input_.readInt64();
/* 1281 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1285 */             long _k_ = 0L;
/* 1286 */             _k_ = _input_.readInt64();
/* 1287 */             int readTag = _input_.readTag();
/* 1288 */             if (74 != readTag)
/*      */             {
/* 1290 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1292 */             xbean.ChangeModelCardInfo _v_ = xbean.Pod.newChangeModelCardInfoData();
/* 1293 */             _input_.readMessage(_v_);
/* 1294 */             this.cardid2info.put(Long.valueOf(_k_), _v_);
/* 1295 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1299 */             this.activated_in_fight = _input_.readBool();
/* 1300 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1304 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1306 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1315 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1319 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1321 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChangeModelCardInfo copy()
/*      */     {
/* 1327 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChangeModelCardInfo toData()
/*      */     {
/* 1333 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2ChangeModelCardInfo toBean()
/*      */     {
/* 1338 */       return new Role2ChangeModelCardInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChangeModelCardInfo toDataIf()
/*      */     {
/* 1344 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2ChangeModelCardInfo toBeanIf()
/*      */     {
/* 1349 */       return new Role2ChangeModelCardInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1355 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1359 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1363 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1367 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1371 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1375 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1379 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getCard_ids()
/*      */     {
/* 1386 */       return this.card_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getCard_idsAsData()
/*      */     {
/* 1393 */       return this.card_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_card_cfg_id()
/*      */     {
/* 1400 */       return this.current_card_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_card_level()
/*      */     {
/* 1407 */       return this.current_card_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getVisible()
/*      */     {
/* 1414 */       return this.visible;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFight_count()
/*      */     {
/* 1421 */       return this.fight_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/* 1428 */       return this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOverlay_count()
/*      */     {
/* 1435 */       return this.overlay_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNext_card_id()
/*      */     {
/* 1442 */       return this.next_card_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChangeModelCardInfo> getCardid2info()
/*      */     {
/* 1449 */       return this.cardid2info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChangeModelCardInfo> getCardid2infoAsData()
/*      */     {
/* 1456 */       return this.cardid2info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getActivated_in_fight()
/*      */     {
/* 1463 */       return this.activated_in_fight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_card_cfg_id(int _v_)
/*      */     {
/* 1470 */       this.current_card_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_card_level(int _v_)
/*      */     {
/* 1477 */       this.current_card_level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVisible(boolean _v_)
/*      */     {
/* 1484 */       this.visible = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_count(int _v_)
/*      */     {
/* 1491 */       this.fight_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1498 */       this.start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOverlay_count(int _v_)
/*      */     {
/* 1505 */       this.overlay_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNext_card_id(long _v_)
/*      */     {
/* 1512 */       this.next_card_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivated_in_fight(boolean _v_)
/*      */     {
/* 1519 */       this.activated_in_fight = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1525 */       if (!(_o1_ instanceof Data)) return false;
/* 1526 */       Data _o_ = (Data)_o1_;
/* 1527 */       if (!this.card_ids.equals(_o_.card_ids)) return false;
/* 1528 */       if (this.current_card_cfg_id != _o_.current_card_cfg_id) return false;
/* 1529 */       if (this.current_card_level != _o_.current_card_level) return false;
/* 1530 */       if (this.visible != _o_.visible) return false;
/* 1531 */       if (this.fight_count != _o_.fight_count) return false;
/* 1532 */       if (this.start_time != _o_.start_time) return false;
/* 1533 */       if (this.overlay_count != _o_.overlay_count) return false;
/* 1534 */       if (this.next_card_id != _o_.next_card_id) return false;
/* 1535 */       if (!this.cardid2info.equals(_o_.cardid2info)) return false;
/* 1536 */       if (this.activated_in_fight != _o_.activated_in_fight) return false;
/* 1537 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1543 */       int _h_ = 0;
/* 1544 */       _h_ += this.card_ids.hashCode();
/* 1545 */       _h_ += this.current_card_cfg_id;
/* 1546 */       _h_ += this.current_card_level;
/* 1547 */       _h_ += (this.visible ? 1231 : 1237);
/* 1548 */       _h_ += this.fight_count;
/* 1549 */       _h_ = (int)(_h_ + this.start_time);
/* 1550 */       _h_ += this.overlay_count;
/* 1551 */       _h_ = (int)(_h_ + this.next_card_id);
/* 1552 */       _h_ += this.cardid2info.hashCode();
/* 1553 */       _h_ += (this.activated_in_fight ? 1231 : 1237);
/* 1554 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1560 */       StringBuilder _sb_ = new StringBuilder();
/* 1561 */       _sb_.append("(");
/* 1562 */       _sb_.append(this.card_ids);
/* 1563 */       _sb_.append(",");
/* 1564 */       _sb_.append(this.current_card_cfg_id);
/* 1565 */       _sb_.append(",");
/* 1566 */       _sb_.append(this.current_card_level);
/* 1567 */       _sb_.append(",");
/* 1568 */       _sb_.append(this.visible);
/* 1569 */       _sb_.append(",");
/* 1570 */       _sb_.append(this.fight_count);
/* 1571 */       _sb_.append(",");
/* 1572 */       _sb_.append(this.start_time);
/* 1573 */       _sb_.append(",");
/* 1574 */       _sb_.append(this.overlay_count);
/* 1575 */       _sb_.append(",");
/* 1576 */       _sb_.append(this.next_card_id);
/* 1577 */       _sb_.append(",");
/* 1578 */       _sb_.append(this.cardid2info);
/* 1579 */       _sb_.append(",");
/* 1580 */       _sb_.append(this.activated_in_fight);
/* 1581 */       _sb_.append(")");
/* 1582 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2ChangeModelCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */